package com.test.datastructure.linearlist.seqlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicAllocationSeqListTest {

    private DynamicAllocationSeqList list;

    @BeforeEach
    void setUp() {
        list = new DynamicAllocationSeqList(4);
        list.insert(1, 1);
        list.insert(1, 1);
        list.insert(1, 1);
        list.insert(1, 1);
    }

    @Test
    void insert() {
        assertTrue(list.insert(1, 3));
        assertTrue(list.length() == 5);
        assertTrue(list.size() == 6);
    }
}