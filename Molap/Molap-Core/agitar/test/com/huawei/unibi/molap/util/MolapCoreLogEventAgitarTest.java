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
 * Generated on 29 Jul, 2013 2:30:57 PM
 * Time to generate: 00:14.256 seconds
 *
 */

package com.huawei.unibi.molap.util;

import com.agitar.lib.junit.AgitarTestCase;

public class MolapCoreLogEventAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return MolapCoreLogEvent.class;
    }
    
    public void testGetEventCode() throws Throwable {
        String result = MolapCoreLogEvent.UNIBI_MOLAPCORE_MSG.getEventCode();
        assertEquals("result", "molap.core", result);
    }
    
    public void testGetModuleName() throws Throwable {
        String result = MolapCoreLogEvent.UNIBI_MOLAPCORE_MSG.getModuleName();
        assertEquals("result", "MOLAP_CORE", result);
    }
    
    public void testValueOf() throws Throwable {
        MolapCoreLogEvent result = MolapCoreLogEvent.valueOf("UNIBI_MOLAPCORE_MSG");
        assertEquals("result", MolapCoreLogEvent.UNIBI_MOLAPCORE_MSG, result);
    }
    
    public void testValues() throws Throwable {
        MolapCoreLogEvent[] result = MolapCoreLogEvent.values();
        assertEquals("result.length", 1, result.length);
        assertEquals("result[0]", MolapCoreLogEvent.UNIBI_MOLAPCORE_MSG, result[0]);
    }
    
    public void testValueOfThrowsIllegalArgumentException() throws Throwable {
        try {
            MolapCoreLogEvent.valueOf("testMolapCoreLogEventParam1");
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals("ex.getMessage()", "No enum const class com.huawei.unibi.molap.util.MolapCoreLogEvent.testMolapCoreLogEventParam1", ex.getMessage());
            assertThrownBy(Enum.class, ex);
        }
    }
    
    public void testValueOfThrowsNullPointerException() throws Throwable {
        try {
            MolapCoreLogEvent.valueOf(null);
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertEquals("ex.getMessage()", "Name is null", ex.getMessage());
            assertThrownBy(Enum.class, ex);
        }
    }
}

