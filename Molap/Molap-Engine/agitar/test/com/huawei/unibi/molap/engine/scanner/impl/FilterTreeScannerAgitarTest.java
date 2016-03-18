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
 * Generated on 29 Jul, 2013 4:53:15 PM
 * Time to generate: 00:30.263 seconds
 *
 */

package com.huawei.unibi.molap.engine.scanner.impl;

import com.agitar.lib.junit.AgitarTestCase;
import com.agitar.lib.mockingbird.Mockingbird;
import com.huawei.iweb.platform.logging.LogService;
import com.huawei.unibi.molap.datastorage.store.FileHolder;
import com.huawei.unibi.molap.datastorage.store.impl.FileHolderImpl;
import com.huawei.unibi.molap.engine.datastorage.DataStore;
import com.huawei.unibi.molap.engine.datastorage.DataStoreBlock;
import com.huawei.unibi.molap.engine.datastorage.tree.CSBInternalNode;
import com.huawei.unibi.molap.engine.datastorage.tree.CSBTree;
import com.huawei.unibi.molap.engine.datastorage.tree.HierarchyBtreeStore;
import com.huawei.unibi.molap.engine.filters.InMemFilterModel;
import com.huawei.unibi.molap.engine.filters.InMemoryFilter;
import com.huawei.unibi.molap.engine.filters.KeyFilterImpl;
import com.huawei.unibi.molap.engine.scanner.BTreeScanner;
import com.huawei.unibi.molap.keygenerator.KeyGenerator;
import com.huawei.unibi.molap.keygenerator.mdkey.AbstractKeyGenerator;
import com.huawei.unibi.molap.keygenerator.mdkey.MultiDimKeyVarLengthGenerator;

public class FilterTreeScannerAgitarTest extends AgitarTestCase {
    
    public Class getTargetClass()  {
        return FilterTreeScanner.class;
    }
    
    public void testConstructor() throws Throwable {
        byte[] endKey = new byte[0];
        int[] msrs = new int[2];
        byte[] startKey = new byte[1];
        KeyValue currKey = new KeyValue();
        FileHolder fileHolder = new FileHolderImpl();
        int[] lens = new int[0];
        KeyGenerator keyGenerator = new MultiDimKeyVarLengthGenerator(lens);
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, keyGenerator, currKey, msrs, fileHolder);
        assertSame("currKey.getMsrCols()", msrs, currKey.getMsrCols());
        assertFalse("filterTreeScanner.filterPresent", filterTreeScanner.filterPresent);
        assertSame("filterTreeScanner.getFileHolder()", fileHolder, filterTreeScanner.getFileHolder());
        assertEquals("filterTreeScanner.blockKeys", 0, ((Number) getPrivateField(filterTreeScanner, "blockKeys")).intValue());
        assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
        assertSame("filterTreeScanner.msrs", msrs, getPrivateField(filterTreeScanner, "msrs"));
        assertEquals("filterTreeScanner.index", -1, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
        assertSame("filterTreeScanner.endKey", endKey, getPrivateField(filterTreeScanner, "endKey"));
        assertSame("filterTreeScanner.keyGenerator", keyGenerator, getPrivateField(filterTreeScanner, "keyGenerator"));
    }
    
    public void testHasNext() throws Throwable {
        int[] lens = new int[0];
        int[] lens2 = new int[0];
        byte[] endKey = new byte[3];
        byte[] startKey = new byte[2];
        int[] msrs = new int[1];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, new MultiDimKeyVarLengthGenerator(lens2), new KeyValue(), msrs, null);
        filterTreeScanner.setDataStore(new HierarchyBtreeStore(new MultiDimKeyVarLengthGenerator(lens)), new CSBInternalNode(0, 100, "testFilterTreeScannerTableName"), 100);
        boolean result = filterTreeScanner.hasNext();
        assertFalse("result", result);
        assertEquals("filterTreeScanner.index", 0, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
        assertNull("filterTreeScanner.block", getPrivateField(filterTreeScanner, "block"));
    }
    
    public void testHasNext1() throws Throwable {
        int[] lens = new int[3];
        byte[] startKey = new byte[1];
        byte[] endKey = new byte[3];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, new MultiDimKeyVarLengthGenerator(lens), new KeyValue(), lens, new FileHolderImpl(100));
        boolean result = filterTreeScanner.hasNext();
        assertFalse("result", result);
    }
    
    public void testHasNextWithAggressiveMocks() throws Throwable {
        FilterTreeScanner filterTreeScanner = (FilterTreeScanner) Mockingbird.getProxyObject(FilterTreeScanner.class, true);
        byte[] bytes = new byte[0];
        KeyValue keyValue = (KeyValue) Mockingbird.getProxyObject(KeyValue.class);
        KeyGenerator keyGenerator = (KeyGenerator) Mockingbird.getProxyObject(KeyGenerator.class);
        InMemoryFilter inMemoryFilter = (InMemoryFilter) Mockingbird.getProxyObject(InMemoryFilter.class);
        byte[] bytes2 = new byte[0];
        byte[] bytes3 = new byte[0];
        byte[] bytes4 = new byte[0];
        setPrivateField(filterTreeScanner, "block", Mockingbird.getProxyObject(DataStoreBlock.class));
        setPrivateField(filterTreeScanner, "index", new Integer(1));
        setPrivateField(filterTreeScanner, "blockKeys", new Integer(4));
        setPrivateField(filterTreeScanner, "endKey", bytes);
        setPrivateField(filterTreeScanner, "currKey", keyValue);
        setPrivateField(filterTreeScanner, "keyGenerator", keyGenerator);
        filterTreeScanner.filter = inMemoryFilter;
        keyValue.setReset(true);
        keyValue.setBackKeyArray(bytes2);
        keyValue.setKeyOffset(0);
        keyValue.setKeyLength(0);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(false, keyGenerator, "compare", "(byte[],int,int,byte[],int,int)int", new Integer(-1), 1);
        Mockingbird.setReturnValue(inMemoryFilter.filterKey(keyValue), false);
        Mockingbird.setReturnValue(inMemoryFilter.getNextJump(keyValue), bytes3);
        Mockingbird.setReturnValue(keyValue.searchInternal(bytes3, keyGenerator), 0);
        keyValue.setRow(0);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, keyGenerator, "compare", "(byte[],int,int,byte[],int,int)int", new Integer(-1), 1);
        Mockingbird.setReturnValue(inMemoryFilter.filterKey(keyValue), false);
        Mockingbird.setReturnValue(inMemoryFilter.getNextJump(keyValue), bytes4);
        Mockingbird.setReturnValue(false, keyValue, "searchInternal", "(byte[],com.huawei.unibi.molap.keygenerator.KeyGenerator)int", new Integer(0), 1);
        keyValue.setRow(0);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, keyGenerator, "compare", "(byte[],int,int,byte[],int,int)int", new Integer(-1), 1);
        Mockingbird.setReturnValue(inMemoryFilter.filterKey(keyValue), false);
        Mockingbird.setReturnValue(inMemoryFilter.getNextJump(keyValue), null);
        keyValue.increment();
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, keyGenerator, "compare", "(byte[],int,int,byte[],int,int)int", new Integer(-1), 1);
        Mockingbird.setReturnValue(inMemoryFilter.filterKey(keyValue), false);
        Mockingbird.setReturnValue(false, inMemoryFilter, "getNextJump", "(com.huawei.unibi.molap.engine.scanner.impl.KeyValue)byte[]", null, 1);
        keyValue.increment();
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(false, keyGenerator, "compare", "(byte[],int,int,byte[],int,int)int", new Integer(1), 1);
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        boolean result = filterTreeScanner.hasNext();
        assertFalse("result", result);
        assertEquals("filterTreeScanner.getNext().getArray().length", 0, filterTreeScanner.getNext().getArray().length);
        assertEquals("filterTreeScanner.blockKeys", 4, ((Number) getPrivateField(filterTreeScanner, "blockKeys")).intValue());
        assertEquals("filterTreeScanner.index", 5, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
        assertNull("filterTreeScanner.store", getPrivateField(filterTreeScanner, "store"));
        assertNotNull("filterTreeScanner.filter", filterTreeScanner.filter);
        assertNotNull("filterTreeScanner.block", getPrivateField(filterTreeScanner, "block"));
        assertNotNull("filterTreeScanner.keyGenerator", getPrivateField(filterTreeScanner, "keyGenerator"));
    }
    
    public void testSearchInternal() throws Throwable {
        byte[] startKey = new byte[0];
        byte[] endKey = new byte[0];
        MultiDimKeyVarLengthGenerator keyGenerator = (MultiDimKeyVarLengthGenerator) Mockingbird.getProxyObject(MultiDimKeyVarLengthGenerator.class);
        KeyValue currKey = (KeyValue) Mockingbird.getProxyObject(KeyValue.class);
        int[] msrs = new int[0];
        FileHolderImpl fileHolder = (FileHolderImpl) Mockingbird.getProxyObject(FileHolderImpl.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(keyGenerator.getKeySizeInBytes(), 0);
        currKey.setKeyLength(0);
        Mockingbird.setNormalReturnForVoid();
        currKey.setMsrCols(msrs);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, keyGenerator, currKey, msrs, fileHolder);
        CSBTree dataStore = (CSBTree) Mockingbird.getProxyObject(CSBTree.class);
        CSBInternalNode block = (CSBInternalNode) Mockingbird.getProxyObject(CSBInternalNode.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(block.getnKeys(), 0);
        currKey.setBlock(block, fileHolder);
        Mockingbird.setNormalReturnForVoid();
        currKey.reset();
        Mockingbird.setNormalReturnForVoid();
        currKey.setRow(1);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(block.getValueSize(), (short)0);
        currKey.setValueLength((short)0);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        filterTreeScanner.setDataStore(dataStore, block, 1);
        byte[] bytes = new byte[0];
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(currKey.searchInternal(bytes, keyGenerator), -1);
        Mockingbird.setReturnValue(dataStore.getNext(bytes, filterTreeScanner), null);
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        boolean result = ((Boolean) callPrivateMethod("com.huawei.unibi.molap.engine.scanner.impl.FilterTreeScanner", "searchInternal", new Class[] {byte[].class}, filterTreeScanner, new Object[] {bytes})).booleanValue();
        assertTrue("result", result);
        assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
        assertSame("filterTreeScanner.store", dataStore, getPrivateField(filterTreeScanner, "store"));
    }
    
    public void testSearchInternal1() throws Throwable {
        int[] lens = new int[4];
        KeyValue currKey = new KeyValue();
        DataStore dataStore = new CSBTree(100, 1000, 0);
        byte[] bytes = new byte[0];
        byte[] startKey = new byte[2];
        byte[] endKey = new byte[0];
        int[] msrs = new int[1];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, new MultiDimKeyVarLengthGenerator(lens), currKey, msrs, new FileHolderImpl());
        filterTreeScanner.setDataStore(dataStore, null, 100);
        boolean result = ((Boolean) callPrivateMethod("com.huawei.unibi.molap.engine.scanner.impl.FilterTreeScanner", "searchInternal", new Class[] {byte[].class}, filterTreeScanner, new Object[] {bytes})).booleanValue();
        assertFalse("result", result);
        assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
        assertSame("filterTreeScanner.store", dataStore, getPrivateField(filterTreeScanner, "store"));
    }
    
    public void testSearchInternal2() throws Throwable {
        byte[] startKey = new byte[0];
        byte[] endKey = new byte[0];
        MultiDimKeyVarLengthGenerator keyGenerator = (MultiDimKeyVarLengthGenerator) Mockingbird.getProxyObject(MultiDimKeyVarLengthGenerator.class);
        KeyValue currKey = (KeyValue) Mockingbird.getProxyObject(KeyValue.class);
        int[] msrs = new int[0];
        FileHolderImpl fileHolder = (FileHolderImpl) Mockingbird.getProxyObject(FileHolderImpl.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(keyGenerator.getKeySizeInBytes(), 0);
        currKey.setKeyLength(0);
        Mockingbird.setNormalReturnForVoid();
        currKey.setMsrCols(msrs);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, keyGenerator, currKey, msrs, fileHolder);
        byte[] bytes = new byte[0];
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(currKey.searchInternal(bytes, keyGenerator), 2147483641);
        currKey.setRow(2147483641);
        Mockingbird.setNormalReturnForVoid();
        currKey.setReset(true);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        boolean result = ((Boolean) callPrivateMethod("com.huawei.unibi.molap.engine.scanner.impl.FilterTreeScanner", "searchInternal", new Class[] {byte[].class}, filterTreeScanner, new Object[] {bytes})).booleanValue();
        assertTrue("result", result);
        assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
        assertEquals("filterTreeScanner.index", 2147483641, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
    }
    
    public void testSetFilter() throws Throwable {
        int[] lens = new int[0];
        byte[] startKey = new byte[3];
        byte[] endKey = new byte[2];
        int[] msrs = new int[3];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, new MultiDimKeyVarLengthGenerator(lens), new KeyValue(), msrs, new FileHolderImpl(100));
        long[] maxKey = new long[2];
        int[] lens2 = new int[0];
        InMemoryFilter filter = new KeyFilterImpl(new InMemFilterModel(), new MultiDimKeyVarLengthGenerator(lens2), maxKey);
        filterTreeScanner.setFilter(filter);
        assertSame("filterTreeScanner.filter", filter, filterTreeScanner.filter);
        boolean actual = ((LogService) getPrivateField(FilterTreeScanner.class, "LOGGER")).isDebugEnabled();
        assertTrue("filterTreeScannerFilterTreeScanner.LOGGER.isDebugEnabled()", actual);
    }
    
    public void testConstructorThrowsNullPointerException() throws Throwable {
        KeyValue currKey = new KeyValue();
        byte[] startKey = new byte[3];
        byte[] endKey = new byte[0];
        int[] msrs = new int[1];
        try {
            new FilterTreeScanner(startKey, endKey, null, currKey, msrs, new FileHolderImpl());
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(BTreeScanner.class, ex);
        }
    }
    
    public void testHasNextThrowsArrayIndexOutOfBoundsException() throws Throwable {
        int[] lens = new int[0];
        int[] lens2 = new int[1];
        lens2[0] = -3;
        KeyGenerator keyGenerator = new MultiDimKeyVarLengthGenerator(lens2);
        DataStore dataStore = new CSBTree(new MultiDimKeyVarLengthGenerator(lens), 100, "testFilterTreeScannerTableName", true);
        KeyValue currKey = new KeyValue();
        byte[] endKey = new byte[2];
        DataStoreBlock block = new CSBInternalNode(0, 100, "testFilterTreeScannerTableName");
        byte[] startKey = new byte[2];
        int[] msrs = new int[1];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, keyGenerator, currKey, msrs, new FileHolderImpl());
        filterTreeScanner.setDataStore(dataStore, block, -1);
        try {
            filterTreeScanner.hasNext();
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "-1", ex.getMessage());
            assertThrownBy(AbstractKeyGenerator.class, ex);
            assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
            assertEquals("filterTreeScanner.index", 0, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
            assertSame("filterTreeScanner.keyGenerator", keyGenerator, getPrivateField(filterTreeScanner, "keyGenerator"));
            assertEquals("filterTreeScanner.blockKeys", -1, ((Number) getPrivateField(filterTreeScanner, "blockKeys")).intValue());
            assertSame("filterTreeScanner.store", dataStore, getPrivateField(filterTreeScanner, "store"));
            assertNull("filterTreeScanner.filter", filterTreeScanner.filter);
            assertSame("filterTreeScanner.block", block, getPrivateField(filterTreeScanner, "block"));
        }
    }
    
    public void testHasNextThrowsNullPointerException() throws Throwable {
        byte[] startKey = new byte[0];
        byte[] endKey = new byte[0];
        MultiDimKeyVarLengthGenerator keyGenerator = (MultiDimKeyVarLengthGenerator) Mockingbird.getProxyObject(MultiDimKeyVarLengthGenerator.class);
        KeyValue currKey = (KeyValue) Mockingbird.getProxyObject(KeyValue.class);
        int[] msrs = new int[0];
        FileHolderImpl fileHolder = (FileHolderImpl) Mockingbird.getProxyObject(FileHolderImpl.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(keyGenerator.getKeySizeInBytes(), -11);
        currKey.setKeyLength(-11);
        Mockingbird.setNormalReturnForVoid();
        currKey.setMsrCols(msrs);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, keyGenerator, currKey, msrs, fileHolder);
        CSBTree dataStore = (CSBTree) Mockingbird.getProxyObject(CSBTree.class);
        CSBInternalNode block = (CSBInternalNode) Mockingbird.getProxyObject(CSBInternalNode.class);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(block.getnKeys(), 0);
        currKey.setBlock(block, fileHolder);
        Mockingbird.setNormalReturnForVoid();
        currKey.reset();
        Mockingbird.setNormalReturnForVoid();
        currKey.setRow(-5);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.setReturnValue(block.getValueSize(), (short)0);
        currKey.setValueLength((short)0);
        Mockingbird.setNormalReturnForVoid();
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        filterTreeScanner.setDataStore(dataStore, block, -5);
        KeyFilterImpl filter = (KeyFilterImpl) Mockingbird.getProxyObject(KeyFilterImpl.class);
        filterTreeScanner.setFilter(filter);
        Mockingbird.enterRecordingMode();
        Mockingbird.setReturnValue(currKey.isReset(), true);
        currKey.setReset(false);
        Mockingbird.setNormalReturnForVoid();
        byte[] bytes = new byte[0];
        Mockingbird.setReturnValue(currKey.getArray(), bytes);
        Mockingbird.setReturnValue(currKey.getKeyOffset(), 55);
        Mockingbird.setReturnValue(currKey.getKeyLength(), -11);
        Mockingbird.setReturnValue(keyGenerator.compare(bytes, 100, 1000, endKey, 0, -1), 0);
        Mockingbird.setException(filter.filterKey(currKey), (Throwable) Mockingbird.getProxyObject(NullPointerException.class));
        Mockingbird.enterTestMode(FilterTreeScanner.class);
        try {
            filterTreeScanner.hasNext();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
            assertEquals("filterTreeScanner.index", -4, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
            assertSame("filterTreeScanner.filter", filter, filterTreeScanner.filter);
            assertSame("filterTreeScanner.keyGenerator", keyGenerator, getPrivateField(filterTreeScanner, "keyGenerator"));
            assertEquals("filterTreeScanner.blockKeys", -1, ((Number) getPrivateField(filterTreeScanner, "blockKeys")).intValue());
            assertSame("filterTreeScanner.store", dataStore, getPrivateField(filterTreeScanner, "store"));
            assertSame("filterTreeScanner.block", block, getPrivateField(filterTreeScanner, "block"));
        }
    }
    
    public void testHasNextThrowsNullPointerException1() throws Throwable {
        int[] lens = new int[0];
        KeyValue currKey = new KeyValue();
        DataStoreBlock block = new CSBInternalNode(100, 1000, "testFilterTreeScannerTableName");
        byte[] startKey = new byte[3];
        int[] msrs = new int[0];
        KeyGenerator keyGenerator = new MultiDimKeyVarLengthGenerator(lens);
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, null, keyGenerator, currKey, msrs, null);
        DataStore dataStore = new CSBTree(100, 1000, 0);
        filterTreeScanner.setDataStore(dataStore, block, -1);
        try {
            filterTreeScanner.hasNext();
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(FilterTreeScanner.class, ex);
            assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
            assertEquals("filterTreeScanner.index", 0, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
            assertNull("filterTreeScanner.filter", filterTreeScanner.filter);
            assertEquals("filterTreeScanner.blockKeys", -1, ((Number) getPrivateField(filterTreeScanner, "blockKeys")).intValue());
            assertSame("filterTreeScanner.store", dataStore, getPrivateField(filterTreeScanner, "store"));
            assertSame("filterTreeScanner.block", block, getPrivateField(filterTreeScanner, "block"));
            assertSame("filterTreeScanner.keyGenerator", keyGenerator, getPrivateField(filterTreeScanner, "keyGenerator"));
        }
    }
    
    public void testSearchInternalThrowsArrayIndexOutOfBoundsException() throws Throwable {
        int[] lens = new int[0];
        int[] lens2 = new int[1];
        lens2[0] = -3;
        DataStore dataStore = new CSBTree(new MultiDimKeyVarLengthGenerator(lens), 100, "testFilterTreeScannerTableName", true);
        KeyValue currKey = new KeyValue();
        byte[] endKey = new byte[2];
        byte[] startKey = new byte[2];
        int[] msrs = new int[1];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, new MultiDimKeyVarLengthGenerator(lens2), currKey, msrs, new FileHolderImpl());
        filterTreeScanner.setDataStore(dataStore, new CSBInternalNode(0, 100, "testFilterTreeScannerTableName"), -3);
        byte[] bytes = new byte[0];
        try {
            callPrivateMethod("com.huawei.unibi.molap.engine.scanner.impl.FilterTreeScanner", "searchInternal", new Class[] {byte[].class}, filterTreeScanner, new Object[] {bytes});
            fail("Expected ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException ex) {
            assertEquals("ex.getMessage()", "0", ex.getMessage());
            assertThrownBy(AbstractKeyGenerator.class, ex);
            assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
            assertEquals("filterTreeScanner.index", -3, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
            assertSame("filterTreeScanner.store", dataStore, getPrivateField(filterTreeScanner, "store"));
        }
    }
    
    public void testSearchInternalThrowsNullPointerException() throws Throwable {
        byte[] endKey = new byte[0];
        int[] msrs = new int[2];
        KeyValue currKey = new KeyValue();
        int[] lens = new int[0];
        byte[] startKey = new byte[0];
        FilterTreeScanner filterTreeScanner = new FilterTreeScanner(startKey, endKey, new MultiDimKeyVarLengthGenerator(lens), currKey, msrs, new FileHolderImpl(100));
        try {
            callPrivateMethod("com.huawei.unibi.molap.engine.scanner.impl.FilterTreeScanner", "searchInternal", new Class[] {byte[].class}, filterTreeScanner, new Object[] {endKey});
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException ex) {
            assertNull("ex.getMessage()", ex.getMessage());
            assertThrownBy(FilterTreeScanner.class, ex);
            assertSame("filterTreeScanner.getNext()", currKey, filterTreeScanner.getNext());
            assertNull("filterTreeScanner.store", getPrivateField(filterTreeScanner, "store"));
            assertEquals("filterTreeScanner.index", -1, ((Number) getPrivateField(filterTreeScanner, "index")).intValue());
        }
    }
}

