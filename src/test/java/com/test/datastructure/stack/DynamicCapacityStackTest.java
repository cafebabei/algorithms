package com.test.datastructure.stack;

import com.test.datastructure.stack.seq.DynamicCapacityStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DynamicCapacityStackTest {

    @Test
    void pushExtendCapacity() {
        DynamicCapacityStack dynamicCapacityStack = new DynamicCapacityStack(3);
        dynamicCapacityStack.push(1);
        dynamicCapacityStack.push(1);
        dynamicCapacityStack.push(1);
        assertDoesNotThrow(() -> dynamicCapacityStack.push(1));

        dynamicCapacityStack.push(1);
        dynamicCapacityStack.push(1);
        assertDoesNotThrow(() -> dynamicCapacityStack.push(1));
    }

}