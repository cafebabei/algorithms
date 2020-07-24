package com.none.datastructure.stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FixedCapacityStackTest {

    @Test
    @DisplayName("容量初始化异常")
    void initCapacityException() {
        assertThrows(java.lang.AssertionError.class, () -> new FixedCapacityStack(0));
    }

    @Test
    void StackPushPopTest() {
        FixedCapacityStack stack = new FixedCapacityStack(3);
        assertTrue(stack.size() == 0);

        stack.push(1);
        stack.push(2);
        assertTrue(stack.size() == 2);

        assertEquals(2, (int) stack.pop());
        assertTrue(stack.size() == 1);
    }

    @Test
    void StackOverflowCapacityException() {
        FixedCapacityStack stack = new FixedCapacityStack(1);
        stack.push(1);
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> stack.push(2));
    }

}