package com.ixingji.calculator.unit;

public abstract class CalculateUnit {

    public abstract CalculateUnitType type();

    public enum CalculateUnitType {
        NUMBER,
        OPERATOR;
    }

}
