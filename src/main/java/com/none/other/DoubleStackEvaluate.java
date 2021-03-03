package com.none.other;

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * Dijkstra的双栈算术表达式求值算法
 * 1。忽略左括号
 * 2。操作数入栈
 * 3。运算符入栈
 * 4。右括号计算
 */
public class DoubleStackEvaluate {

    public static Double evaluate(final String expression) {
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();
        String expressionD = expression;
        while (StringUtils.isNotBlank(expressionD)) {
            String current = expressionD.substring(0, 1);
            expressionD = expressionD.substring(1);
            //忽略右括号
            if (current.equals("(")) continue;
                //操作符入栈
            else if (current.equals("+")) operators.push(current);
            else if (current.equals("-")) operators.push(current);
            else if (current.equals("*")) operators.push(current);
            else if (current.equals("/")) operators.push(current);
                //右括号计算
            else if (current.equals(")")) {
                String operator = operators.pop();
                Double value = values.pop();
                if (operator.equals("+")) value = values.pop() + value;
                else if (operator.equals("-")) value = values.pop() - value;
                else if (operator.equals("*")) value = values.pop() * value;
                else if (operator.equals("/")) value = values.pop() / value;
                values.push(value);
            } else values.push(Double.parseDouble(current));
        }
        return values.pop();
    }


}
