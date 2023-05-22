package org.example.problems.evaluate_reverse_polish_notation;

import org.example.problems.SolutionInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Evaluate Reverse Polish Notation";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/evaluate-reverse-polish-notation/";
    }

    private static final Map<String, BinaryOperator<Integer>> callbacks = new HashMap<>() {
        {
            put("+", Integer::sum);
            put("-", (p1, p2) -> p1 - p2);
            put("/", (p1, p2) -> p1 / p2);
            put("*", (p1, p2) -> p1 * p2);
        }
    };

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s: tokens) {
            stack.push(s);
        }
        return eval(stack);
    }

    private int eval(Stack<String> stack) {
        String token = stack.pop();
        BinaryOperator<Integer> callback = callbacks.getOrDefault(token, null);
        if (callback == null) { // token is digit
            assert token != null;
            return Integer.parseInt(token);
        }
        Integer secondParam = eval(stack);
        Integer firstParam = eval(stack);
        return callback.apply(firstParam, secondParam);
    }
}
