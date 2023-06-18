package org.example.problems.min_stack;

import org.example.problems.SolutionInterface;

import java.util.Stack;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Min Stack";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/min-stack/";
    }

    private record ValueWithMin(int value, int minimum) {}

    private final Stack<ValueWithMin> stack = new Stack<>();

    public void push(int val) {
        int min;
        if (stack.empty()) {
            min = val;
        } else {
            min = stack.peek().minimum;
        }

        stack.push(new ValueWithMin(val, Math.min(min, val)));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().minimum;
    }
}
