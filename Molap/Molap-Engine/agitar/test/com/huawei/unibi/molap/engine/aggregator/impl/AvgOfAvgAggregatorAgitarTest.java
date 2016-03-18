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
 * Generated by Agitar build: AgitarOne Version 5.3.0.000022 (Build date: Jan 04, 2012) [5.3.0.000022]
 * JDK Version: 1.6.0_14
 *
 * Generated on 29 Jul, 2013 4:48:33 PM
 * Time to generate: 00:12.224 seconds
 *
 */

package com.huawei.unibi.molap.engine.aggregator.impl;

import com.agitar.lib.junit.AgitarTestCase;

public class AvgOfAvgAggregatorAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return AvgOfAvgAggregator.class;
    }
    
    public void testConstructor() throws Throwable {
        new AvgOfAvgAggregator();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testAgg() throws Throwable {
        AvgOfAvgAggregator avgOfAvgAggregator = new AvgOfAvgAggregator();
        avgOfAvgAggregator.agg(100.0, 1000.0);
        assertEquals("avgOfAvgAggregator.count", 1000.0, avgOfAvgAggregator.count, 1.0E-6);
        assertEquals("avgOfAvgAggregator.aggVal", 100000.0, avgOfAvgAggregator.aggVal, 1.0E-6);
    }
}

