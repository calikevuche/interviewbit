package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 27.10.2016.
 */
public class MinStack {

    Integer minValue = -1;
    Stack<Integer> stack = new Stack();
    Stack<Integer> minStack = new Stack();

    public void push(int x) {
        if (stack.isEmpty() || x < minValue) {
            minValue = x;
            minStack.push(x);
        } else if (minValue == x) {
            minStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty()){
            int value = stack.pop();
            if (value == minValue) {
                minStack.pop();
                minValue = minStack.isEmpty() ? -1 : minStack.peek();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int getMin() {
        return minValue;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(10);
        minStack.push(9);
        minStack.getMin();
        minStack.push(8);
        minStack.push(7);
        minStack.push(6);
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        minStack.getMin();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
