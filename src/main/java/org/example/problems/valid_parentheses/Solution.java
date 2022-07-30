package org.example.problems.valid_parentheses;

import org.example.problems.SolutionInterface;

import java.util.Stack;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Valid Parentheses";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/valid-parentheses/";
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (isOpen(c)) {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char open = stack.pop();
                if (!isMatch(open, c)) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    private boolean isOpen(char c) {
        return c == '['
            || c == '('
            || c == '{';
    }

    private boolean isMatch(char open, char closed) {
        return (open == '[' && closed == ']')
            || (open == '(' && closed == ')')
            || (open == '{' && closed == '}');
    }
}
