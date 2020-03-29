package com.ixingji.calculator.unit;

import lombok.Getter;

public class NumberCalculateUnit extends CalculateUnit {

    @Getter
    int value;

    public NumberCalculateUnit(int value) {
        this.value = value;
    }

    @Override
    public CalculateUnitType type() {
        return CalculateUnitType.NUMBER;
    }

    @Override
    public String toString() {
        return "NumberCalculateUnit{" +
                "value=" + value +
                '}';
    }

}
