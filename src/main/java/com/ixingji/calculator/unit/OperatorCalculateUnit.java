package com.ixingji.calculator.unit;

import com.ixingji.calculator.Operator;
import lombok.Getter;

public class OperatorCalculateUnit extends CalculateUnit {

    @Getter
    private Operator value;

    public OperatorCalculateUnit(Operator value) {
        this.value = value;
    }

    @Override
    public CalculateUnitType type() {
        return CalculateUnitType.OPERATOR;
    }

    @Override
    public String toString() {
        return "OperatorCalculateUnit{" +
                "value=" + value +
                '}';
    }

}
