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
 * Generated on 29 Jul, 2013 2:34:40 PM
 * Time to generate: 00:17.132 seconds
 *
 */

package com.huawei.unibi.molap.datastorage.store.compression.type;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.iweb.platform.logging.LogService;
import com.huawei.unibi.molap.datastorage.store.compression.Compressor;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressionUtil;
import com.huawei.unibi.molap.datastorage.store.compression.ValueCompressonHolder;
import com.huawei.unibi.molap.util.MolapCoreLogEvent;
import java.nio.ByteBuffer;

public class UnCompressNonDecimalMaxMinDefaultAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return UnCompressNonDecimalMaxMinDefault.class;
    }
    
    public void testConstructor() throws Throwable {
        new UnCompressNonDecimalMaxMinDefault();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testCompressWithAggressiveMocks() throws Throwable {
        storeStaticField(UnCompressNonDecimalMaxMinDefault.class, "doubleCompressor");
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = (UnCompressNonDecimalMaxMinDefault) Mockingbird.getProxyObject(UnCompressNonDecimalMaxMinDefault.class, true);
        double[] doubles = new double[0];
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(UnCompressNonDecimalMaxMinByte.class, "<init>()", new UnCompressNonDecimalMaxMinByte());
        Compressor compressor = (Compressor) Mockingbird.getProxyObject(Compressor.class);
        byte[] bytes = new byte[0];
        Mockingbird.enterNormalMode();
        unCompressNonDecimalMaxMinDefault.setValue(doubles);
        setPrivateField(UnCompressNonDecimalMaxMinDefault.class, "doubleCompressor", compressor);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(compressor.compress(doubles), bytes);
        Mockingbird.enterTestMode(UnCompressNonDecimalMaxMinDefault.class);
        ValueCompressonHolder.UnCompressValue result = unCompressNonDecimalMaxMinDefault.compress();
        assertEquals("result.getBackArrayData().length", 0, result.getBackArrayData().length);
        assertNotNull("unCompressNonDecimalMaxMinDefaultUnCompressNonDecimalMaxMinDefault.doubleCompressor", getPrivateField(UnCompressNonDecimalMaxMinDefault.class, "doubleCompressor"));
    }
    
    public void testGetBackArrayData() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        double[] value = new double[0];
        unCompressNonDecimalMaxMinDefault.setValue(value);
        byte[] result = unCompressNonDecimalMaxMinDefault.getBackArrayData();
        assertEquals("result.length", 0, result.length);
    }
    
    public void testGetBackArrayData1() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        double[] value = new double[5];
        unCompressNonDecimalMaxMinDefault.setValue(value);
        byte[] result = unCompressNonDecimalMaxMinDefault.getBackArrayData();
        assertEquals("result.length", 40, result.length);
        assertEquals("result[0]", (byte)0, result[0]);
    }
    
    public void testGetCompressorObject() throws Throwable {
        UnCompressNonDecimalMaxMinByte result = (UnCompressNonDecimalMaxMinByte) new UnCompressNonDecimalMaxMinDefault().getCompressorObject();
        assertNull("result.getBackArrayData()", result.getBackArrayData());
    }
    
    public void testGetNew() throws Throwable {
        UnCompressNonDecimalMaxMinDefault result = (UnCompressNonDecimalMaxMinDefault) new UnCompressNonDecimalMaxMinDefault().getNew();
        assertNotNull("result", result);
    }
    
    public void testGetNewWithAggressiveMocks() throws Throwable {
        storeStaticField(UnCompressNonDecimalMaxMinDefault.class, "LOGGER");
        storeStaticField(MolapCoreLogEvent.class, "UNIBI_MOLAPCORE_MSG");
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = (UnCompressNonDecimalMaxMinDefault) Mockingbird.getProxyObject(UnCompressNonDecimalMaxMinDefault.class, true);
        CloneNotSupportedException cloneNotSupportedException = (CloneNotSupportedException) Mockingbird.getProxyObject(CloneNotSupportedException.class);
        LogService logService = (LogService) Mockingbird.getProxyObject(LogService.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(false, unCompressNonDecimalMaxMinDefault, "clone", "()java.lang.Object", new Object[] {}, cloneNotSupportedException, 1);
        setPrivateField(UnCompressNonDecimalMaxMinDefault.class, "LOGGER", logService);
        setPrivateField(MolapCoreLogEvent.class, "UNIBI_MOLAPCORE_MSG", null);
        Mockingbird.setReturnValue(false, cloneNotSupportedException, "getMessage", "()java.lang.String", new Object[] {}, "", 1);
        Mockingbird.setReturnValue(false, logService, "error", "(com.huawei.iweb.platform.logging.LogEvent,java.lang.Throwable,java.lang.Object[])void", null, 1);
        Mockingbird.enterTestMode(UnCompressNonDecimalMaxMinDefault.class);
        ValueCompressonHolder.UnCompressValue result = unCompressNonDecimalMaxMinDefault.getNew();
        assertNull("result", result);
    }
    
    public void testGetValue() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        double[] value = new double[3];
        unCompressNonDecimalMaxMinDefault.setValue(value);
        double result = unCompressNonDecimalMaxMinDefault.getValue(0, -1, 100.0);
        assertEquals("result", 1000.0, result, 1.0E-6);
    }
    
    public void testGetValue1() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        double[] value = new double[1];
        unCompressNonDecimalMaxMinDefault.setValue(value);
        double result = unCompressNonDecimalMaxMinDefault.getValue(0, 100, 100.0);
        assertEquals("result", 1.0E-98, result, 1.0E-6);
    }
    
    public void testSetValue() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        double[] value = new double[0];
        unCompressNonDecimalMaxMinDefault.setValue(value);
        assertEquals("unCompressNonDecimalMaxMinDefault.getBackArrayData().length", 0, unCompressNonDecimalMaxMinDefault.getBackArrayData().length);
    }
    
    public void testSetValueInBytes() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        byte[] value = new byte[1];
        unCompressNonDecimalMaxMinDefault.setValueInBytes(value);
        assertEquals("unCompressNonDecimalMaxMinDefault.getBackArrayData().length", 0, unCompressNonDecimalMaxMinDefault.getBackArrayData().length);
    }
    
    public void testUncompress() throws Throwable {
        ValueCompressonHolder.UnCompressValue result = new UnCompressNonDecimalMaxMinDefault().uncompress(ValueCompressionUtil.DataType.DATA_SHORT);
        assertNull("result", result);
    }
    
    public void testGetBackArrayDataThrowsNullPointerException() throws Throwable {
        try {
            new UnCompressNonDecimalMaxMinDefault().getBackArrayData();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ValueCompressionUtil.class, ex);
        }
    }
    
    public void testGetValueThrowsArrayIndexOutOfBoundsException() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        byte[] value = new byte[2];
        unCompressNonDecimalMaxMinDefault.setValueInBytes(value);
        try {
            unCompressNonDecimalMaxMinDefault.getValue(100, 1000, 100.0);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "100", ex.getMessage());
            assertThrownBy(UnCompressNonDecimalMaxMinDefault.class, ex);
        }
    }
    
    public void testGetValueThrowsNullPointerException() throws Throwable {
        try {
            new UnCompressNonDecimalMaxMinDefault().getValue(100, 1000, 100.0);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(UnCompressNonDecimalMaxMinDefault.class, ex);
        }
    }
    
    public void testSetValueInBytesThrowsNullPointerException() throws Throwable {
        UnCompressNonDecimalMaxMinDefault unCompressNonDecimalMaxMinDefault = new UnCompressNonDecimalMaxMinDefault();
        try {
            unCompressNonDecimalMaxMinDefault.setValueInBytes((byte[]) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteBuffer.class, ex);
            assertNull("unCompressNonDecimalMaxMinDefault.value", getPrivateField(unCompressNonDecimalMaxMinDefault, "value"));
        }
    }
}

