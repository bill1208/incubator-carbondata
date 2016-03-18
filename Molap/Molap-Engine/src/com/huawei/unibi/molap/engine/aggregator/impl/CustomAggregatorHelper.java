/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/**
 *
 * Copyright Notice
 * =====================================
 * This file contains proprietary information of
 * Huawei Technologies India Pvt Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2014
 * =====================================
 *
 */
package com.huawei.unibi.molap.engine.aggregator.impl;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

import com.huawei.iweb.platform.logging.LogService;
import com.huawei.iweb.platform.logging.LogServiceFactory;
import com.huawei.unibi.molap.constants.MolapCommonConstants;
import com.huawei.unibi.molap.engine.util.MolapEngineLogEvent;
import com.huawei.unibi.molap.util.MolapProperties;
import com.huawei.unibi.molap.util.MolapUtil;

/**
 * Project Name NSE V3R8C10 
 * Module Name : MOLAP Data Processor
 * Author :k00900841 
 * Created Date:10-Aug-2014
 * FileName : CustomeAggregatorHelper.java
 * Class Description : Helper class for custom aggregator to get dim values
 * Class Version 1.0
 */
public class CustomAggregatorHelper
{
    /**
     * LOGGER
     */
    private static final LogService LOGGER = LogServiceFactory.getLogService(CustomAggregatorHelper.class.getName());

    /**
     * surrogateKeyMap
     */
    private Map<String, Map<Integer, String>> surrogateKeyMap;
    
    /**
     * loadFolderList
     */
    private List<File>   loadFolderList;
    
    public CustomAggregatorHelper()
    {
        surrogateKeyMap = new HashMap<String, Map<Integer, String>>(MolapCommonConstants.DEFAULT_COLLECTION_SIZE);
        loadFolderList = new ArrayList<File>(MolapCommonConstants.DEFAULT_COLLECTION_SIZE);
    }

    /**
     * Below method will be used to get the member 
     * @param tableName
     * @param columnName
     * @param key
     * @param cubeName
     * @param schemaName
     * @return member
     */
    public String getDimValue(String tableName,String columnName, int key, String cubeName,String schemaName)
    {
        Map<Integer, String> memberCache = surrogateKeyMap.get(tableName + '_' + columnName);
        if(null == memberCache)
        {
            loadLevelFile(tableName, columnName, cubeName, schemaName);
        }
        memberCache=surrogateKeyMap.get(tableName + '_' + columnName);
        return memberCache.get(key);
    }

    /**
     * Below method will be used to fill the level cache
     * @param tableName
     * @param columnName
     * @param cubeName
     * @param schemaName
     */
    private void loadLevelFile(String tableName, String columnName, String cubeName, String schemaName)
    {
        String baseLocation = MolapUtil.getCarbonStorePath(schemaName, cubeName)/*MolapProperties.getInstance().getProperty(MolapCommonConstants.STORE_LOCATION,
                MolapCommonConstants.STORE_LOCATION_DEFAULT_VAL)*/;
        baseLocation = baseLocation + File.separator + schemaName + File.separator + cubeName;
        if(loadFolderList.size()==0)
        {
            checkAndUpdateFolderList(baseLocation);
        }
        try
        {
            File[] filesArray= null;
          //CHECKSTYLE:OFF    Approval No:Approval-367
            for(File loadFoler : loadFolderList)
            {
              //CHECKSTYLE:ON
                filesArray = getFilesArray(loadFoler, tableName + '_' + columnName);
                for(int i = 0;i < filesArray.length;i++)
                {
                    readLevelFileAndUpdateCache(filesArray[i], tableName + '_' + columnName);
                }
            }
        }
        catch(IOException e)
        {
            LOGGER.error(MolapEngineLogEvent.UNIBI_MOLAPENGINE_MSG, "Problem while populating the cache");
        }
    }

    /**
     * Below method will be used to read the level files
     * @param memberFile
     * @param fileName
     * @throws IOException
     * @throws KettleException
     * 
     */
    private void readLevelFileAndUpdateCache(File memberFile, String fileName) throws IOException
    {
        FileInputStream fos = null;
        FileChannel fileChannel = null;
        try
        {
            // create an object of FileOutputStream
            fos = new FileInputStream(memberFile);

            fileChannel = fos.getChannel();
            Map<Integer, String> memberMap = surrogateKeyMap.get(fileName);

            if(null == memberMap)
            {
                memberMap = new HashMap<Integer, String>(MolapCommonConstants.DEFAULT_COLLECTION_SIZE);
                surrogateKeyMap.put(fileName, memberMap);
            }

            long size = fileChannel.size();
            int maxKey = 0;
            ByteBuffer rowlengthToRead = null;
            int len = 0;
            ByteBuffer row = null;
            int toread = 0;
            byte[] bb = null;
            String value = null;// CHECKSTYLE:OFF Approval No:Approval-361
            int surrogateValue = 0;
            
            boolean enableEncoding = Boolean.valueOf(MolapProperties.getInstance().getProperty(
                    MolapCommonConstants.ENABLE_BASE64_ENCODING,
                    MolapCommonConstants.ENABLE_BASE64_ENCODING_DEFAULT));
            
            while(fileChannel.position() < size)
            {
                rowlengthToRead = ByteBuffer.allocate(4);
                fileChannel.read(rowlengthToRead);
                rowlengthToRead.rewind();
                len = rowlengthToRead.getInt();
                if(len == 0)
                {
                    continue;
                }

                row = ByteBuffer.allocate(len);
                fileChannel.read(row);
                row.rewind();
                toread = row.getInt();
                bb = new byte[toread];
                row.get(bb);
                
                if(enableEncoding)
                {
                    value = new String(Base64.decodeBase64(bb), Charset.defaultCharset());
                }
                else
                {
                    value = new String(bb, Charset.defaultCharset());
                }
                
                surrogateValue = row.getInt();
                memberMap.put(surrogateValue, value);

                // check if max key is less than Surrogate key then update the
                // max
                // key
                if(maxKey < surrogateValue)
                {
                    maxKey = surrogateValue;
                }
            }

        }
        finally
        {
            MolapUtil.closeStreams(fileChannel, fos);
        }
    }

    /**
     * This method recursively checks the folder with Load_ inside each and
     * every RS_x/TableName/Load_x and add in the folder list the load folders.
     * 
     * @param baseStorePath
     * @return
     * 
     */
    private File[] checkAndUpdateFolderList(String baseStorePath)
    {
        File folders = new File(baseStorePath);
        //
        File[] rsFolders = folders.listFiles(new FileFilter()
        {
            @Override
            public boolean accept(File pathname)
            {
                boolean check = false;
                check = pathname.isDirectory()
                        && pathname.getAbsolutePath().indexOf(MolapCommonConstants.LOAD_FOLDER) > -1;
                if(check)
                {
                    return true;
                }
                else
                {
                    File[] checkFolder = checkAndUpdateFolderList(pathname.getAbsolutePath());
                    if(null != checkFolder)
                    {
                      //CHECKSTYLE:OFF    Approval No:Approval-367
                        for(File f : checkFolder)
                        {//CHECKSTYLE:ON
                            loadFolderList.add(f);
                        }
                    }
                }
                return false;
            }
        });
        return rsFolders;
    }
    
    /**
     * Below method will be used to get the file list
     * @param baseStorePath
     * @param fileNameSearchPattern
     * @return
     */
    private static File[] getFilesArray(File baseStorePath, final String fileNameSearchPattern)
    {
        File[] listFiles = baseStorePath.listFiles(new FileFilter()
        {
            @Override
            public boolean accept(File pathname)
            {
                if(pathname.getName().indexOf(fileNameSearchPattern) > -1)
                {
                    return true;
                }
                return false;
            }
        });
        return listFiles;
    }
}
