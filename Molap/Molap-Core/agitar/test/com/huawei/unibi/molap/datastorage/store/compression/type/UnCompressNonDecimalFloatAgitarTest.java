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
 * Generated on 29 Jul, 2013 2:34:13 PM
 * Time to generate: 00:16.617 seconds
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

public class UnCompressNonDecimalFloatAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return UnCompressNonDecimalFloat.class;
    }
    
    public void testConstructor() throws Throwable {
        new UnCompressNonDecimalFloat();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testCompressWithAggressiveMocks() throws Throwable {
        storeStaticField(UnCompressNonDecimalFloat.class, "floatCompressor");
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = (UnCompressNonDecimalFloat) Mockingbird.getProxyObject(UnCompressNonDecimalFloat.class, true);
        float[] floats = new float[0];
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(UnCompressNonDecimalByte.class, "<init>()", new UnCompressNonDecimalByte());
        Compressor compressor = (Compressor) Mockingbird.getProxyObject(Compressor.class);
        byte[] bytes = new byte[0];
        Mockingbird.enterNormalMode();
        unCompressNonDecimalFloat.setValue(floats);
        setPrivateField(UnCompressNonDecimalFloat.class, "floatCompressor", compressor);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(compressor.compress(floats), bytes);
        Mockingbird.enterTestMode(UnCompressNonDecimalFloat.class);
        ValueCompressonHolder.UnCompressValue result = unCompressNonDecimalFloat.compress();
        assertEquals("result.getBackArrayData().length", 0, result.getBackArrayData().length);
        assertNotNull("unCompressNonDecimalFloatUnCompressNonDecimalFloat.floatCompressor", getPrivateField(UnCompressNonDecimalFloat.class, "floatCompressor"));
    }
    
    public void testGetBackArrayData() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        float[] value = new float[0];
        unCompressNonDecimalFloat.setValue(value);
        byte[] result = unCompressNonDecimalFloat.getBackArrayData();
        assertEquals("result.length", 0, result.length);
    }
    
    public void testGetBackArrayData1() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        float[] value = new float[2];
        unCompressNonDecimalFloat.setValue(value);
        byte[] result = unCompressNonDecimalFloat.getBackArrayData();
        assertEquals("result.length", 8, result.length);
        assertEquals("result[0]", (byte)0, result[0]);
    }
    
    public void testGetCompressorObject() throws Throwable {
        UnCompressNonDecimalByte result = (UnCompressNonDecimalByte) new UnCompressNonDecimalFloat().getCompressorObject();
        assertNull("result.getBackArrayData()", result.getBackArrayData());
    }
    
    public void testGetNew() throws Throwable {
        UnCompressNonDecimalFloat result = (UnCompressNonDecimalFloat) new UnCompressNonDecimalFloat().getNew();
        assertNotNull("result", result);
    }
    
    public void testGetNewWithAggressiveMocks() throws Throwable {
        storeStaticField(MolapCoreLogEvent.class, "UNIBI_MOLAPCORE_MSG");
        storeStaticField(UnCompressNonDecimalFloat.class, "LOGGER");
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = (UnCompressNonDecimalFloat) Mockingbird.getProxyObject(UnCompressNonDecimalFloat.class, true);
        CloneNotSupportedException cloneNotSupportedException = (CloneNotSupportedException) Mockingbird.getProxyObject(CloneNotSupportedException.class);
        LogService logService = (LogService) Mockingbird.getProxyObject(LogService.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(false, unCompressNonDecimalFloat, "clone", "()java.lang.Object", new Object[] {}, cloneNotSupportedException, 1);
        setPrivateField(UnCompressNonDecimalFloat.class, "LOGGER", logService);
        setPrivateField(MolapCoreLogEvent.class, "UNIBI_MOLAPCORE_MSG", null);
        Mockingbird.setReturnValue(false, cloneNotSupportedException, "getMessage", "()java.lang.String", new Object[] {}, "", 1);
        Mockingbird.setReturnValue(false, logService, "error", "(com.huawei.iweb.platform.logging.LogEvent,java.lang.Throwable,java.lang.Object[])void", null, 1);
        Mockingbird.enterTestMode(UnCompressNonDecimalFloat.class);
        ValueCompressonHolder.UnCompressValue result = unCompressNonDecimalFloat.getNew();
        assertNull("result", result);
    }
    
    public void testGetValue() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        float[] value = new float[3];
        value[0] = 3.9182894F;
        unCompressNonDecimalFloat.setValue(value);
        double result = unCompressNonDecimalFloat.getValue(0, -1, 100.0);
        assertEquals("result", 39.182894229888916, result, 1.0E-6);
    }
    
    public void testGetValue1() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        float[] value = new float[1];
        unCompressNonDecimalFloat.setValue(value);
        double result = unCompressNonDecimalFloat.getValue(0, 100, 100.0);
        assertEquals("result", 0.0, result, 1.0E-6);
    }
    
    public void testSetValue() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        float[] value = new float[0];
        unCompressNonDecimalFloat.setValue(value);
        assertEquals("unCompressNonDecimalFloat.getBackArrayData().length", 0, unCompressNonDecimalFloat.getBackArrayData().length);
    }
    
    public void testSetValueInBytes() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        byte[] value = new byte[1];
        unCompressNonDecimalFloat.setValueInBytes(value);
        assertEquals("unCompressNonDecimalFloat.getBackArrayData().length", 0, unCompressNonDecimalFloat.getBackArrayData().length);
    }
    
    public void testUncompress() throws Throwable {
        ValueCompressonHolder.UnCompressValue result = new UnCompressNonDecimalFloat().uncompress(ValueCompressionUtil.DataType.DATA_SHORT);
        assertNull("result", result);
    }
    
    public void testGetBackArrayDataThrowsNullPointerException() throws Throwable {
        try {
            new UnCompressNonDecimalFloat().getBackArrayData();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ValueCompressionUtil.class, ex);
        }
    }
    
    public void testGetValueThrowsArrayIndexOutOfBoundsException() throws Throwable {
        float[] value = new float[3];
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        unCompressNonDecimalFloat.setValue(value);
        try {
            unCompressNonDecimalFloat.getValue(100, 1000, 100.0);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "100", ex.getMessage());
            assertThrownBy(UnCompressNonDecimalFloat.class, ex);
        }
    }
    
    public void testGetValueThrowsNullPointerException() throws Throwable {
        try {
            new UnCompressNonDecimalFloat().getValue(100, 1000, 100.0);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(UnCompressNonDecimalFloat.class, ex);
        }
    }
    
    public void testSetValueInBytesThrowsNullPointerException() throws Throwable {
        UnCompressNonDecimalFloat unCompressNonDecimalFloat = new UnCompressNonDecimalFloat();
        try {
            unCompressNonDecimalFloat.setValueInBytes((byte[]) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteBuffer.class, ex);
            assertNull("unCompressNonDecimalFloat.value", getPrivateField(unCompressNonDecimalFloat, "value"));
        }
    }
}

