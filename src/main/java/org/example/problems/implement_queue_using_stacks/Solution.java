package org.example.problems.implement_queue_using_stacks;

import org.example.problems.SolutionInterface;

import java.util.Stack;

public class Solution implements SolutionInterface {
    @Override
    public String getName() {
        return "Implement Queue using Stacks";
    }

    @Override
    public String getUrl() {
        return "https://leetcode.com/problems/implement-queue-using-stacks/";
    }

    Stack<Integer> readStack = new Stack<>();
    Stack<Integer> writeStack = new Stack<>();

    public void push(int x) {
        if (writeStack.empty() && !readStack.empty()) {
            fillStack(readStack, writeStack);
        }

        writeStack.push(x);
    }

    public int pop() {
        if (readStack.empty() && !writeStack.empty()) {
            fillStack(writeStack, readStack);
        }
        return readStack.pop();
    }

    public int peek() {
        if (readStack.empty() && !writeStack.empty()) {
            fillStack(writeStack, readStack);
        }
        return readStack.peek();
    }

    public boolean empty() {
        return writeStack.empty() && readStack.empty();
    }

    private void fillStack(Stack<Integer> from, Stack<Integer> to) {
        while (!to.empty()) {
            to.pop();
        }
        while (!from.empty()) {
            to.push(from.pop());
        }
    }
}
