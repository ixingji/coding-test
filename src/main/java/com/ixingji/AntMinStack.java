package com.ixingji;

import java.util.Enumeration;
import java.util.Objects;
import java.util.Random;
import java.util.Stack;

public class AntMinStack {

    private Stack<Integer> stack = new Stack<>();

    private Stack<Integer> minStack = new Stack<>();


    public void push(Integer target) {
        stack.push(target);
        if (minStack.empty()) {
            minStack.push(target);
        } else if (minStack.peek() > target) {
            minStack.push(target);
        }
    }

    public void print() {
        Enumeration<Integer> stackElements = stack.elements();
        while (stackElements.hasMoreElements()) {
            System.err.print(stackElements.nextElement() + ",");
        }
    }

    public Integer pop() {
        Integer target = stack.pop();
        if (Objects.equals(target, minStack.peek())) {
            minStack.pop();
        }
        return target;
    }

    public Integer min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        AntMinStack minStack = new AntMinStack();
        Random ran = new Random();

        for (int i = 0; i < 10; i++) {
            minStack.push(ran.nextInt(100));
            minStack.print();
            System.err.println("--- " + minStack.min());
        }
    }

}
