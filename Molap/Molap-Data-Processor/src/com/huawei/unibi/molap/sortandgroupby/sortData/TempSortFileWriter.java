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

package com.huawei.unibi.molap.sortandgroupby.sortData;

import java.io.File;

import com.huawei.unibi.molap.sortandgroupby.exception.MolapSortKeyAndGroupByException;

/**
 * Project Name 	: Carbon 
 * Module Name 		: MOLAP Data Processor
 * Author 			: Suprith T 72079 
 * Created Date 	: 24-Aug-2015
 * FileName 		: TempSortFileWriter.java
 * Description 		: Interface for writing the sort temp file
 * Class Version 	: 1.0
 */
public interface TempSortFileWriter
{
    /**
     * Method will be used to initialize
     * @param file
     * @param entryCount
     * @throws MolapSortKeyAndGroupByException
     */
    void initiaize(File file,int entryCount) throws MolapSortKeyAndGroupByException;

    /**
     * Method will be used to finish 
     */
    void finish();
    
    /**
     * Below method will be used to write the sort temp file
     * @param records
     * @throws MolapSortKeyAndGroupByException
     */
    void writeSortTempFile(Object[][] records)throws MolapSortKeyAndGroupByException;
}
