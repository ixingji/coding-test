package com.ixingji.calculator;

/**
 * Add, subtract, multiply and divide
 * left parenthesis
 */
public enum Operator {

    LEFT_PARENT('(', 1),
    RIGHT_PARENT(')', 1),
    ADD('+', 3),
    SUB('-', 3),
    MUL('*', 5),
    DIV('/', 5);

    private char value;
    private int priority;

    Operator(char value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public static Operator valueOf(char valueChar) {
        for (Operator operator : values()) {
            if (operator.value == valueChar) {
                return operator;
            }
        }
        throw new RuntimeException("Unknown Operator");
    }

    public static int comparePriority(Operator operator1, Operator operator2) {
        return operator1.priority - operator2.priority;
    }

    public static void main(String[] args) {
        System.err.println(Operator.valueOf('-'));
    }

}
