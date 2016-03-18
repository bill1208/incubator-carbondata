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

/*--------------------------------------------------------------------------------------------------------------------------*/
/*!!Warning: This is a key information asset of Huawei Tech Co.,Ltd                                                         */
/*CODEMARK:kOyQZYzjDpyGdBAEC2GaWmnksNUG9RKxzMKuuAYTdbJ5ajFrCnCGALet/FDi0nQqbEkSZoTs
2wdXgejaKCr1dP3uE3wfvLHF9gW8+IdXbweRARwUrjYxPx0CUk3mVB7mxOcZSaagKrMQNlhB
QO/t7NDZ1syssSr328bAtYw0uoQPiL5sxeLPrIT7M2CgCHxC4IrbZ4pSEGqOTV6URmIv3ebY
/+SHb3j51404xhLOyuLAE/98Tpy7pEQV4Gdhh0s56V+cEGeY6HP8W6v+JUTGLQ==*/
/*--------------------------------------------------------------------------------------------------------------------------*/
/**
 * Copyright Notice
 * =====================================
 * This file contains proprietary information of
 * Huawei Technologies India Pvt Ltd.
 * Copying or reproduction without prior written approval is prohibited.
 * Copyright (c) 2013
 * =====================================
*/

package com.huawei.unibi.molap.engine.executer.impl;

import java.util.Comparator;

/**
 * Project Name NSE V3R7C00 
 * Module Name : MOLAP
 * Author V00900840
 * Created Date :13-May-2013 3:06:35 PM
 * FileName : ResultComparartor.java
 * Class Description : Result Comparator compare the result data.
 * Version 1.0
 */
public class ResultComparartor implements Comparator<double[]>
{

    private int sortIndex;
    
    private int sortOrder;

    public ResultComparartor(int sortIndex, int sortOrder)
    {
        this.sortIndex = sortIndex;
        this.sortOrder = sortOrder;
    }

    @Override
    public int compare(double[] o1, double[] o2)
    {
        int compareResult = 0;
        if(o1[sortIndex]<o2[sortIndex])
        {
            compareResult=-1;
        }
        else if(o1[sortIndex]>o2[sortIndex])
        {
            compareResult=1;
        }
        if(sortOrder>0)
        {
            compareResult=-1*compareResult;
        }
        return compareResult;
    }

}

