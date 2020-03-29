package com.ixingji.calculator;

import com.ixingji.calculator.unit.CalculateUnit;
import com.ixingji.calculator.unit.NumberCalculateUnit;
import com.ixingji.calculator.unit.OperatorCalculateUnit;

import java.util.ArrayList;
import java.util.List;

public class Expression {

    private String value;

    public Expression(String value) {
        this.value = value;
    }

    public List<CalculateUnit> analyzeCalculateUnits() {
        List<CalculateUnit> calculateUnits = new ArrayList<>();

        StringBuilder builder = new StringBuilder();
        for (char valueChar : value.toCharArray()) {
            if (Character.isDigit(valueChar)) {
                builder.append(valueChar);
            } else {
                if (builder.length() > 0) {
                    calculateUnits.add(new NumberCalculateUnit(Integer.parseInt(builder.toString())));
                    builder.delete(0, builder.length());
                }
                calculateUnits.add(new OperatorCalculateUnit(Operator.valueOf(valueChar)));
            }
        }
        if (builder.length() > 0) {
            calculateUnits.add(new NumberCalculateUnit(Integer.parseInt(builder.toString())));
            builder.delete(0, builder.length());
        }
        return calculateUnits;
    }

    public static void main(String[] args) {
        Expression expression = new Expression("(1+21)/3");
        System.err.println(expression.analyzeCalculateUnits());
    }

}
