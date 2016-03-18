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
 */
package com.huawei.datasight.molap.query.metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.huawei.unibi.molap.engine.aggregator.MeasureAggregator;

/**
 * To hold the reference to Molap column (measure or dimension in the given expression)
 * 
 * @author K00900207
 * 
 */
public class MolapQueryExpression implements Serializable
{

    /**
     *<code>serialVersionUID</code>
     */
    private static final long serialVersionUID = -8173358957132456045L;

    /**
     * Enum to specify the column usage. Weather used as part of expression OR this column alone.
     * 
     * @author K00900207
     * 
     */
    public static enum UsageType {
        SINGLE, // Only this measure is used
        EXPRESSION; // Used as part of expression
    }

    /**
     * Expression used in query
     */
    private String expression;
    
    /**
     * usageType
     */
    private UsageType usageType;

    /**
     * Referred columns
     */
    private List<MolapColumn> columns = new ArrayList<MolapColumn>();
    
    public List<MolapColumn> getColumns()
    {
        return columns;
    }

    /**
     * Identified and delegated from Spark Layer for UDAF in Molap 
     */
    private MeasureAggregator aggregator;
    
    /**
     * queryOrder
     */
    private int queryOrder;

    /**
     * sort order type. default is no order.
     */
    private SortOrderType sortOrderType = SortOrderType.NONE;
    
    /**
     * @return the sortOrderType
     */
    public SortOrderType getSortOrderType() 
    {
        return sortOrderType;
    }

    /**
     * @param sortOrderType the sortOrderType to set
     */
    public void setSortOrderType(SortOrderType sortOrderType) 
    {
        this.sortOrderType = sortOrderType;
    }
    
    public MolapQueryExpression(String expression, UsageType usageType)
    {
        this.expression = expression;
        this.usageType = usageType;
    }

    public void addColumn(MolapColumn column)
    {
        columns.add(column);
    }

    public String getExpression()
    {
        return expression;
    }
    
    public UsageType getUsageType()
    {
        return usageType;
    }
    
    /**
     * @return MeasureAggregator
     */
    public MeasureAggregator getAggregator() {
        return aggregator;
    }

    /**
     * @param aggregator
     */
    public void setAggregator(MeasureAggregator aggregator) {
        this.aggregator = aggregator;
    }
    
    public int getQueryOrder() {
        return queryOrder;
    }

    public void setQueryOrder(int queryOrder) {
        this.queryOrder = queryOrder;
    }
}
