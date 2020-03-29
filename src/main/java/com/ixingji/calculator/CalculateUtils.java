package com.ixingji.calculator;

import com.ixingji.calculator.unit.NumberCalculateUnit;
import com.ixingji.calculator.unit.OperatorCalculateUnit;

public class CalculateUtils {

    public static NumberCalculateUnit calculate(OperatorCalculateUnit operatorCalculateUnit, NumberCalculateUnit[] numberCalculateUnits) {
        NumberCalculateUnit resultNumberCalculateUnit = null;

        int leftNumberValue = numberCalculateUnits[1].getValue();
        int rightNumberValue = numberCalculateUnits[0].getValue();

        switch (operatorCalculateUnit.getValue()) {
            case ADD:
                resultNumberCalculateUnit = new NumberCalculateUnit(leftNumberValue + rightNumberValue);
                break;
            case SUB:
                resultNumberCalculateUnit = new NumberCalculateUnit(leftNumberValue - rightNumberValue);
                break;
            case MUL:
                resultNumberCalculateUnit = new NumberCalculateUnit(leftNumberValue * rightNumberValue);
                break;
            case DIV:
                resultNumberCalculateUnit = new NumberCalculateUnit(leftNumberValue / rightNumberValue);
                break;
            default:
                break;
        }

        return resultNumberCalculateUnit;
    }

}
