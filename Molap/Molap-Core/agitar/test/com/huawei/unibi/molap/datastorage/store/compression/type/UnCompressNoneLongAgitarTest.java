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
 * Generated on 29 Jul, 2013 2:35:51 PM
 * Time to generate: 00:16.507 seconds
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

public class UnCompressNoneLongAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return UnCompressNoneLong.class;
    }
    
    public void testConstructor() throws Throwable {
        new UnCompressNoneLong();
        assertTrue("Test call resulted in expected outcome", true);
    }
    
    public void testCompressWithAggressiveMocks() throws Throwable {
        storeStaticField(UnCompressNoneLong.class, "longCompressor");
        UnCompressNoneLong unCompressNoneLong = (UnCompressNoneLong) Mockingbird.getProxyObject(UnCompressNoneLong.class, true);
        long[] longs = new long[0];
        Mockingbird.enterRecordingMode();
        Mockingbird.replaceObjectForRecording(UnCompressNoneByte.class, "<init>()", new UnCompressNoneByte());
        Compressor compressor = (Compressor) Mockingbird.getProxyObject(Compressor.class);
        byte[] bytes = new byte[0];
        Mockingbird.enterNormalMode();
        unCompressNoneLong.setValue(longs);
        setPrivateField(UnCompressNoneLong.class, "longCompressor", compressor);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(compressor.compress(longs), bytes);
        Mockingbird.enterTestMode(UnCompressNoneLong.class);
        ValueCompressonHolder.UnCompressValue result = unCompressNoneLong.compress();
        assertEquals("result.getBackArrayData().length", 0, result.getBackArrayData().length);
        assertNotNull("unCompressNoneLongUnCompressNoneLong.longCompressor", getPrivateField(UnCompressNoneLong.class, "longCompressor"));
    }
    
    public void testGetBackArrayData() throws Throwable {
        long[] value = new long[0];
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        unCompressNoneLong.setValue(value);
        byte[] result = unCompressNoneLong.getBackArrayData();
        assertEquals("result.length", 0, result.length);
    }
    
    public void testGetBackArrayData1() throws Throwable {
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        long[] value = new long[1];
        unCompressNoneLong.setValue(value);
        byte[] result = unCompressNoneLong.getBackArrayData();
        assertEquals("result.length", 8, result.length);
        assertEquals("result[0]", (byte)0, result[0]);
    }
    
    public void testGetCompressorObject() throws Throwable {
        UnCompressNoneByte result = (UnCompressNoneByte) new UnCompressNoneLong().getCompressorObject();
        assertNull("result.getBackArrayData()", result.getBackArrayData());
    }
    
    public void testGetNew() throws Throwable {
        UnCompressNoneLong result = (UnCompressNoneLong) new UnCompressNoneLong().getNew();
        assertNotNull("result", result);
    }
    
    public void testGetNewWithAggressiveMocks() throws Throwable {
        storeStaticField(UnCompressNoneLong.class, "LOGGER");
        storeStaticField(MolapCoreLogEvent.class, "UNIBI_MOLAPCORE_MSG");
        UnCompressNoneLong unCompressNoneLong = (UnCompressNoneLong) Mockingbird.getProxyObject(UnCompressNoneLong.class, true);
        CloneNotSupportedException cloneNotSupportedException = (CloneNotSupportedException) Mockingbird.getProxyObject(CloneNotSupportedException.class);
        LogService logService = (LogService) Mockingbird.getProxyObject(LogService.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setException(false, unCompressNoneLong, "clone", "()java.lang.Object", new Object[] {}, cloneNotSupportedException, 1);
        setPrivateField(UnCompressNoneLong.class, "LOGGER", logService);
        setPrivateField(MolapCoreLogEvent.class, "UNIBI_MOLAPCORE_MSG", null);
        Mockingbird.setReturnValue(false, cloneNotSupportedException, "getMessage", "()java.lang.String", new Object[] {}, "", 1);
        Mockingbird.setReturnValue(false, logService, "error", "(com.huawei.iweb.platform.logging.LogEvent,java.lang.Throwable,java.lang.Object[])void", null, 1);
        Mockingbird.enterTestMode(UnCompressNoneLong.class);
        ValueCompressonHolder.UnCompressValue result = unCompressNoneLong.getNew();
        assertNull("result", result);
    }
    
    public void testGetValue() throws Throwable {
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        long[] value = new long[4];
        value[0] = -1L;
        unCompressNoneLong.setValue(value);
        double result = unCompressNoneLong.getValue(0, 100, 100.0);
        assertEquals("result", -1.0, result, 1.0E-6);
    }
    
    public void testGetValue1() throws Throwable {
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        long[] value = new long[1];
        unCompressNoneLong.setValue(value);
        double result = unCompressNoneLong.getValue(0, 100, 100.0);
        assertEquals("result", 0.0, result, 1.0E-6);
    }
    
    public void testSetValue() throws Throwable {
        long[] value = new long[0];
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        unCompressNoneLong.setValue(value);
        assertEquals("unCompressNoneLong.getBackArrayData().length", 0, unCompressNoneLong.getBackArrayData().length);
    }
    
    public void testSetValueInBytes() throws Throwable {
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        byte[] value = new byte[0];
        unCompressNoneLong.setValueInBytes(value);
        assertEquals("unCompressNoneLong.getBackArrayData().length", 0, unCompressNoneLong.getBackArrayData().length);
    }
    
    public void testUncompress() throws Throwable {
        ValueCompressonHolder.UnCompressValue result = new UnCompressNoneLong().uncompress(ValueCompressionUtil.DataType.DATA_LONG);
        assertNull("result", result);
    }
    
    public void testGetBackArrayDataThrowsNullPointerException() throws Throwable {
        try {
            new UnCompressNoneLong().getBackArrayData();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ValueCompressionUtil.class, ex);
        }
    }
    
    public void testGetValueThrowsArrayIndexOutOfBoundsException() throws Throwable {
        long[] value = new long[0];
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        unCompressNoneLong.setValue(value);
        try {
            unCompressNoneLong.getValue(100, 1000, 100.0);
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "100", ex.getMessage());
            assertThrownBy(UnCompressNoneLong.class, ex);
        }
    }
    
    public void testGetValueThrowsNullPointerException() throws Throwable {
        try {
            new UnCompressNoneLong().getValue(100, 1000, 100.0);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(UnCompressNoneLong.class, ex);
        }
    }
    
    public void testSetValueInBytesThrowsNullPointerException() throws Throwable {
        UnCompressNoneLong unCompressNoneLong = new UnCompressNoneLong();
        try {
            unCompressNoneLong.setValueInBytes((byte[]) null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(ByteBuffer.class, ex);
            assertNull("unCompressNoneLong.value", getPrivateField(unCompressNoneLong, "value"));
        }
    }
}

