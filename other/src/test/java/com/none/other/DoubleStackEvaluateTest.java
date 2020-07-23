package com.none.other;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DoubleStackEvaluateTest {

    @Test
    @DisplayName("运算表达式解释器")
    void evaluate() {
        String expression1 = "((1+2)*3)";
        Assertions.assertEquals(DoubleStackEvaluate.evaluate(expression1), 9);

        String expression2 = "((1+2)/3)";
        Assertions.assertEquals(DoubleStackEvaluate.evaluate(expression2), 1);

        String expression3 = "((1+((2+3)*(8/4)))";
        Assertions.assertEquals(DoubleStackEvaluate.evaluate(expression3), 11);
    }
}