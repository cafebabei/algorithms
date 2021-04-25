package com.test.datastructure.linearlist.seqlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StaticAllocationSeqListTest {

    private StaticAllocationSeqList list;

    @BeforeEach
    void setUp() {
        list = new StaticAllocationSeqList(10);
        list.insert(1, 1);
        list.insert(1, 2);
        list.insert(1, 3);
        list.insert(1, 4);
    }

    @Test
    void locateElement() {
        assertTrue(list.locateElement(1) == 4);
    }

    @Test
    void getElement() {
        assertTrue(list.getElement(1) == 4);
    }

    @Test
    void insert() {
        assertTrue(list.insert(5, 100));
        assertTrue(list.getElement(5) == 100);
        assertFalse(list.insert(9, 100));
        assertFalse(list.insert(10, 100));
        assertFalse(list.insert(100, 100));
    }

    @Test
    void delete() {
        assertTrue(list.delete(3));
        assertTrue(list.getElement(3) == 1);
    }
}