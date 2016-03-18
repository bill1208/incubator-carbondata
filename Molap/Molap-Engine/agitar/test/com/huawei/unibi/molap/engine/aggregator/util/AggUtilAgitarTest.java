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
 * Generated on 29 Jul, 2013 4:49:33 PM
 * Time to generate: 01:52.267 seconds
 *
 */

package com.huawei.unibi.molap.engine.aggregator.util;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.iweb.platform.logging.LogService;
import com.huawei.unibi.molap.engine.aggregator.MeasureAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.AvgAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.AvgOfAvgAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.CountAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.DistinctCountAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.MaxAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.MinAggregator;
import com.huawei.unibi.molap.engine.aggregator.impl.SumAggregator;
import com.huawei.unibi.molap.engine.datastorage.InMemoryCube;
import com.huawei.unibi.molap.engine.util.MolapEngineLogEvent;
import com.huawei.unibi.molap.keygenerator.KeyGenerator;
import com.huawei.unibi.molap.metadata.MolapMetadata;
import java.util.List;
import mondrian.olap.MondrianException;
import mondrian.resource.MondrianResource;

public class AggUtilAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return AggUtil.class;
    }
    
    public void testConstructor() throws Throwable {
        new AggUtil();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testAggregate() throws Throwable {
        MeasureAggregator MeasureAggregator = new MaxAggregator();
        double result = AggUtil.aggregate(MeasureAggregator, 100.0, 1000.0, 0.0, -1.0);
        assertEquals("(MaxAggregator) MeasureAggregator.getValue()", 1000.0, ((MaxAggregator) MeasureAggregator).getValue(), 1.0E-6);
        assertEquals("result", 1000.0, result, 1.0E-6);
    }
    
    public void testGetAggregator() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(MinAggregator.class, "<init>()", Mockingbird.getProxyObject(MinAggregator.class));
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = AggUtil.getAggregator("min", false, null, null);
        assertNotNull("result", result);
    }
    
    public void testGetAggregator1() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(MinAggregator.class, "<init>()", Mockingbird.getProxyObject(MinAggregator.class));
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = AggUtil.getAggregator("min", true, null, null);
        assertNotNull("result", result);
    }
    
    public void testGetAggregator2() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(SumAggregator.class, "<init>()", new SumAggregator());
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getAggregator", new Class[] {String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"sum", null, null});
        assertEquals("result.getValue()", 0.0, result.getValue(), 1.0E-6);
    }
    
    public void testGetAggregator3() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(CountAggregator.class, "<init>()", new CountAggregator());
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getAggregator", new Class[] {String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"count", null, null});
        assertEquals("result.getValue()", 0.0, result.getValue(), 1.0E-6);
    }
    
    public void testGetAggregator4() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(MaxAggregator.class, "<init>()", Mockingbird.getProxyObject(MaxAggregator.class));
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getAggregator", new Class[] {String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"max", null, null});
        assertNotNull("result", result);
    }
    
    public void testGetAggregator5() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(AvgAggregator.class, "<init>()", new AvgAggregator());
        Mockingbird.enterTestMode(AggUtil.class);
        callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getAggregator", new Class[] {String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"avg", null, null});
        assertTrue("Test call resulted in expected outcome", true);
        // dependencies on static and environment state led to removal of 1 assertion
    }
    
    public void testGetAggregator6() throws Throwable {
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(DistinctCountAggregator.class, "<init>()", Mockingbird.getProxyObject(DistinctCountAggregator.class));
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getAggregator", new Class[] {String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"distinct-count", null, null});
        assertNotNull("result", result);
    }
    
    public void testGetAggregator7() throws Throwable {
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getAggregator", new Class[] {String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"", null, null});
        assertNull("result", result);
    }
    
    public void testGetAggregators() throws Throwable {
        List list = (List) Mockingbird.getProxyObject(List.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(list.size(), 2);
        Mockingbird.setReturnValue(list.get(0), "avg");
        Mockingbird.replaceObjectForRecording(AvgOfAvgAggregator.class, "<init>()", new AvgOfAvgAggregator());
        Mockingbird.setReturnValue(list.get(1), "avg");
        Mockingbird.replaceObjectForRecording(AvgOfAvgAggregator.class, "<init>()", new AvgOfAvgAggregator());
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator[] result = AggUtil.getAggregators((List) list, true, null, null);
        assertEquals("result.length", 2, result.length);
    }
    
    public void testGetAggregators1() throws Throwable {
        MeasureAggregator measureAggregator = (MeasureAggregator) Mockingbird.getProxyObject(MeasureAggregator.class);
        MeasureAggregator measureAggregator2 = (MeasureAggregator) Mockingbird.getProxyObject(MeasureAggregator.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, AggUtil.class, "getAggregator", "(java.lang.String,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", measureAggregator, 1);
        Mockingbird.setReturnValue(true, AggUtil.class, "getAggregator", "(java.lang.String,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", measureAggregator2, 1);
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator[] result = AggUtil.getAggregators(2, false, null, null);
        assertEquals("result.length", 2, result.length);
        assertNotNull("result[0]", result[0]);
    }
    
    public void testGetAggsWithFactCountAgg() throws Throwable {
        MolapMetadata.Measure[] measures = new MolapMetadata.Measure[2];
        MolapMetadata.Measure measure = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        MolapMetadata.Measure measure2 = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        MeasureAggregator measureAggregator = (MeasureAggregator) Mockingbird.getProxyObject(MeasureAggregator.class);
        MeasureAggregator measureAggregator2 = (MeasureAggregator) Mockingbird.getProxyObject(MeasureAggregator.class);
        measures[0] = measure;
        measures[1] = measure2;
        measure.setAggName("");
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, AggUtil.class, "getAggregator", "(java.lang.String,boolean,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", measureAggregator, 1);
        Mockingbird.enterNormalMode();
        measure2.setAggName("custom");
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, measure2, "getAggClassName", "()java.lang.String", "", 1);
        Mockingbird.setReturnValue(true, AggUtil.class, "getCustomAggregator", "(java.lang.String,java.lang.String,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", measureAggregator2, 1);
        Mockingbird.replaceObjectForRecording(SumAggregator.class, "<init>()", new SumAggregator());
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator[] result = AggUtil.getAggsWithFactCountAgg(measures, true, null, null);
        assertEquals("result.length", 3, result.length);
        assertNotNull("result[0]", result[0]);
    }
    
    public void testGetAggsWithFactCountAgg1() throws Throwable {
        MolapMetadata.Measure[] measures = new MolapMetadata.Measure[2];
        MolapMetadata.Measure measure = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        MolapMetadata.Measure measure2 = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        MeasureAggregator measureAggregator = (MeasureAggregator) Mockingbird.getProxyObject(MeasureAggregator.class);
        MeasureAggregator measureAggregator2 = (MeasureAggregator) Mockingbird.getProxyObject(MeasureAggregator.class);
        measures[0] = measure;
        measures[1] = measure2;
        measure.setAggName("");
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, AggUtil.class, "getAggregator", "(java.lang.String,boolean,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", measureAggregator, 1);
        Mockingbird.enterNormalMode();
        measure2.setAggName("");
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, AggUtil.class, "getAggregator", "(java.lang.String,boolean,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", measureAggregator2, 1);
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator[] result = AggUtil.getAggsWithFactCountAgg(measures, false, null, null);
        assertEquals("result.length", 2, result.length);
        assertNotNull("result[0]", result[0]);
    }
    
    public void testGetCustomAggregator() throws Throwable {
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getCustomAggregator", new Class[] {String.class, String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"", "com.sun.corba.se.spi.activation.Locator", Mockingbird.getProxyObject(KeyGenerator.class), Mockingbird.getProxyObject(InMemoryCube.class)});
        assertNull("result", result);
        assertNotNull("AggUtil.LOGGER", getPrivateField(AggUtil.class, "LOGGER"));
    }
    
    public void testGetCustomAggregator1() throws Throwable {
        storeStaticField(AggUtil.class, "LOGGER");
        storeStaticField(MolapEngineLogEvent.class, "UNIBI_MOLAPENGINE_MSG");
        LogService logService = (LogService) Mockingbird.getProxyObject(LogService.class);
        setPrivateField(AggUtil.class, "LOGGER", logService);
        setPrivateField(MolapEngineLogEvent.class, "UNIBI_MOLAPENGINE_MSG", null);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, Mockingbird.getProxyObject(StringBuilder.class), "toString", "()java.lang.String", "", 1);
        Mockingbird.setReturnValue(false, logService, "error", "(com.huawei.iweb.platform.logging.LogEvent,java.lang.Throwable,java.lang.Object[])void", null, 1);
        Mockingbird.setReturnValue(false, logService, "info", "(com.huawei.iweb.platform.logging.LogEvent,java.lang.Object[])void", null, 1);
        Mockingbird.enterTestMode(AggUtil.class);
        MeasureAggregator result = (MeasureAggregator) callPrivateMethod("com.huawei.unibi.molap.engine.aggregator.util.AggUtil", "getCustomAggregator", new Class[] {String.class, String.class, KeyGenerator.class, InMemoryCube.class}, null, new Object[] {"", "", null, null});
        assertNull("result", result);
        assertNotNull("AggUtil.LOGGER", getPrivateField(AggUtil.class, "LOGGER"));
    }
    
    public void testAggregateThrowsNullPointerException() throws Throwable {
        try {
            AggUtil.aggregate(null, 100.0, 1000.0, 0.0, -1.0);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(AggUtil.class, ex);
        }
    }
    
    public void testGetAggregatorsThrowsMondrianExceptionWithAggressiveMocks() throws Throwable {
        MolapMetadata.Measure[] measures = new MolapMetadata.Measure[3];
        MolapMetadata.Measure measure = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        MolapMetadata.Measure measure2 = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        MolapMetadata.Measure measure3 = (MolapMetadata.Measure) Mockingbird.getProxyObject(MolapMetadata.Measure.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(AvgOfAvgAggregator.class, "<init>()", new AvgOfAvgAggregator());
        MondrianResource mondrianResource = (MondrianResource) Mockingbird.getProxyObject(MondrianResource.class);
        MondrianResource._Def1 _Def1 = (MondrianResource._Def1) Mockingbird.getProxyObject(MondrianResource._Def1.class);
        MondrianException mondrianException = (MondrianException) Mockingbird.getProxyObject(MondrianException.class);
        measures[0] = measure;
        measures[1] = measure2;
        measures[2] = measure3;
        Mockingbird.enterNormalMode();
        measure.setAggName("avg");
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(AvgOfAvgAggregator.class, "<init>()", new AvgOfAvgAggregator());
        Mockingbird.enterNormalMode();
        measure2.setAggName("avg");
        measure3.setAggName("");
        setPrivateField(mondrianResource, "UnknownAggregator", _Def1);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(true, AggUtil.class, "getAggregator", "(java.lang.String,com.huawei.unibi.molap.keygenerator.KeyGenerator,com.huawei.unibi.molap.engine.datastorage.InMemoryCube)com.huawei.unibi.molap.engine.aggregator.MeasureAggregator", null, 1);
        Mockingbird.setReturnValue(MondrianResource.instance(), mondrianResource);
        Mockingbird.setReturnValue(false, _Def1, "ex", "(java.lang.String,java.lang.String)mondrian.olap.MondrianException", mondrianException, 1);
        Mockingbird.enterTestMode(AggUtil.class);
        try {
            AggUtil.getAggregators(measures, true, null, null);
            fail("Expected MondrianException to be thrown");
        } catch (MondrianException ex) {
            assertTrue("Test call resulted in expected outcome", true);
        }
    }
}

