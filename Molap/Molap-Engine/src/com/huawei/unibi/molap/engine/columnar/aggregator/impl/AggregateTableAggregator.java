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

package com.huawei.unibi.molap.engine.columnar.aggregator.impl;

import com.huawei.unibi.molap.engine.columnar.aggregator.ColumnarAggregatorInfo;


public class AggregateTableAggregator extends DataAggregator
{

    public AggregateTableAggregator(boolean isAggTable, ColumnarAggregatorInfo columnarAggregatorInfo)
    {
        super(isAggTable, columnarAggregatorInfo);
        // TODO Auto-generated constructor stub
    }
//    /**
//     * customMeasureIndex
//     */
//    private int [] customMeasureIndex;
//    
//    public AggregateTableAggregator(ColumnarAggregatorInfo columnaraggreagtorInfo)
//    {
//        super(columnaraggreagtorInfo);
//        customMeasureIndex= getCustomMeasureIndex();
//        if(aggTable)
//        {
//            otherMsrIndexes = getOtherMsrIndexesWithOutCustomMeasureAndAverageMeasure();
//        }
//        else
//        {
//            otherMsrIndexes = getOtherMsrIndexesWithOutCustomMeasure();
//        }
//    }
//    
//    private int[] getCustomMeasureIndex()
//    {
//        List<Integer> list = new ArrayList<Integer>(MolapCommonConstants.DEFAULT_COLLECTION_SIZE);
//        for(int i = 0;i < noOfMeasuresInQuery;i++)
//        {
//            if(columnaraggreagtorInfo.getQueryMsrs()[i].getAggName().equals(MolapCommonConstants.CUSTOM)
//                    || columnaraggreagtorInfo.getQueryMsrs()[i].getAggName().equals(MolapCommonConstants.DISTINCT_COUNT))
//            {
//                list.add(i);
//            }
//        }
//        return QueryExecutorUtil.convertIntegerListToIntArray(list);
//    }
//
//    /**
//     * aggregateMsrs
//     * @param available
//     * @param currentMsrRowData
//     */
//    public void aggregateMsrs(AbstractColumnarScanResult keyValue, MeasureAggregator[] currentMsrRowData)
//    {
//        if(aggTable)
//        {
//            aggregateMsrsForAggTable(keyValue, currentMsrRowData);
//            return;
//        }
//        double doubleValue = 0.0;
//        for(int i = 0;i < otherMsrIndexes.length;i++)
//        {
//            doubleValue = keyValue.getNormalMeasureValue(measureOrdinal[otherMsrIndexes[i]]);
//            if(uniqueValues[measureOrdinal[otherMsrIndexes[i]]] != doubleValue)
//            {
//                currentMsrRowData[otherMsrIndexes[i]].agg(doubleValue, null,
//                    0, 0);
//            }
//        }
//        byte[] byteValue= null;
//        for(int i = 0;i < customMeasureIndex.length;i++)
//        {
//            byteValue = keyValue.getCustomMeasureValue(measureOrdinal[customMeasureIndex[i]]);
//            currentMsrRowData[customMeasureIndex[i]].agg(byteValue, null,
//                    0, 0);
//        }
//    }
//    
//    private int[] getOtherMsrIndexesWithOutCustomMeasureAndAverageMeasure()
//    {
//        int[] indexes = new int[noOfMeasuresInQuery-(avgMsrIndexes.length+customMeasureIndex.length)];
//        int k = 0;
//        for(int i = 0;i < noOfMeasuresInQuery;i++)
//        {
//            if(Arrays.binarySearch(avgMsrIndexes, i) < 0
//                    && Arrays.binarySearch(customMeasureIndex, i)<0)
//            {
//                indexes[k++] = i;
//            }
//        }
//        return indexes;
//    }
//    
//    private int[] getOtherMsrIndexesWithOutCustomMeasure()
//    {
//        int[] indexes = new int[noOfMeasuresInQuery-(customMeasureIndex.length)];
//        int k = 0;
//        for(int i = 0;i < noOfMeasuresInQuery;i++)
//        {
//            if(Arrays.binarySearch(customMeasureIndex, i)<0)
//            {
//                indexes[k++] = i;
//            }
//        }
//        return indexes;
//    }
//    
//    /**
//     * aggregateMsrs
//     * @param available
//     * @param currentMsrRowData
//     */
//    protected void aggregateMsrsForAggTable(AbstractColumnarScanResult keyValue, MeasureAggregator[] currentMsrRowData)
//    {
//        double countValue = keyValue.getNormalMeasureValue(measureOrdinal[countMsrIndex]);
//        double avgValue= 0.0;
//        for(int i = 0;i < avgMsrIndexes.length;i++)
//        {
//            avgValue = keyValue.getNormalMeasureValue(measureOrdinal[avgMsrIndexes[i]]);
//            if(uniqueValues[measureOrdinal[avgMsrIndexes[i]]] != avgValue)
//            {
//                currentMsrRowData[avgMsrIndexes[i]].agg(avgValue,countValue);
//            }
//        }
//        double otherValue= 0.0;
//        for(int i = 0;i < otherMsrIndexes.length;i++)
//        {
//            otherValue = keyValue.getNormalMeasureValue(measureOrdinal[otherMsrIndexes[i]]);
//            if(uniqueValues[measureOrdinal[otherMsrIndexes[i]]] != otherValue)
//            {
//                currentMsrRowData[otherMsrIndexes[i]].agg(otherValue,null,
//                        0, 0);
//            }
//        }
//        byte[] byteValue = null;
//        for(int i = 0;i < customMeasureIndex.length;i++)
//        {
//            byteValue = keyValue.getCustomMeasureValue(measureOrdinal[customMeasureIndex[i]]);
//            currentMsrRowData[customMeasureIndex[i]].agg(byteValue,null,
//                    0, 0);
//        }
//    }

}
