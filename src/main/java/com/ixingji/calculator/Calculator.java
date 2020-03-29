package com.ixingji.calculator;

import com.ixingji.calculator.unit.CalculateUnit;
import com.ixingji.calculator.unit.NumberCalculateUnit;
import com.ixingji.calculator.unit.OperatorCalculateUnit;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Calculator {

    static Stack<NumberCalculateUnit> numberStack = new Stack<>();
    static Stack<OperatorCalculateUnit> operatorStack = new Stack<>();

    public static int calculate(Expression expression) {
        List<CalculateUnit> calculateUnits = expression.analyzeCalculateUnits();

        for (CalculateUnit calculateUnit : calculateUnits) {
            switch (calculateUnit.type()) {
                case OPERATOR:
                    if (operatorStack.isEmpty()) {
                        operatorStack.push((OperatorCalculateUnit) calculateUnit);
                    } else {
                        checkOperatorStack((OperatorCalculateUnit) calculateUnit);
                    }
                    break;
                case NUMBER:
                    numberStack.push((NumberCalculateUnit) calculateUnit);
                    break;
                default:
                    break;
            }
        }

        System.err.println(numberStack.size() + " --- " + operatorStack.size());

        while (numberStack.size() != 1) {
            NumberCalculateUnit resultCalculateUnit = CalculateUtils.calculate(operatorStack.pop(), new NumberCalculateUnit[]{numberStack.pop(), numberStack.pop()});
            numberStack.push(resultCalculateUnit);
        }

        return numberStack.pop().getValue();
    }

    private static void checkOperatorStack(OperatorCalculateUnit calculateUnit) {
        if (Objects.equals(calculateUnit.getValue(), Operator.RIGHT_PARENT) && Objects.equals(operatorStack.peek().getValue(), Operator.LEFT_PARENT)) {
            operatorStack.pop();
            return;
        }

        // 发现一个优先级更小的操作符
        if (!operatorStack.empty() && Operator.comparePriority(calculateUnit.getValue(), operatorStack.peek().getValue()) <= 0) {
            NumberCalculateUnit resultCalculateUnit = CalculateUtils.calculate(operatorStack.pop(), new NumberCalculateUnit[]{numberStack.pop(), numberStack.pop()});
            numberStack.push(resultCalculateUnit);
            checkOperatorStack(calculateUnit);
        } else {
            operatorStack.push(calculateUnit);
        }
    }

    public static void main(String[] args) {
//        System.err.println(calculate(new Expression("1+2+3")));
//        System.err.println(calculate(new Expression("1+2*3")));
        System.err.println(calculate(new Expression("(1+2)*3")));
    }

}
