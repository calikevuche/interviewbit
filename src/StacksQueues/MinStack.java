package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 27.10.2016.
 */
public class MinStack {

    private int minValue;
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        minValue = -1;
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x <= minValue) {
            minValue = x;
            minStack.push(x);
        }
        stack.push(x);
    }

    public int pop() {
        int result = -1;
        if (!stack.isEmpty()) {
            result = stack.pop();
            if (result == minValue) {
                minStack.pop();
                minValue = minStack.isEmpty() ? -1 : minStack.peek();
            }
        }
        return result;
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minValue;
    }
}