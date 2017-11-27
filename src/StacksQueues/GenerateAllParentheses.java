package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 13.10.2016.
 */
public class GenerateAllParentheses {

    public int isValid(String a) {
        Stack stack = new Stack();
        char[] chars = a.toCharArray();
        for (char c : chars) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return 0;
                char lastOpened = (char) stack.pop();
                if (lastOpened != getOpened(c)) return 0;
            }
        }
        if (!stack.isEmpty()) return 0;
        return 1;
    }

    public char getOpened(char closed) {
        switch (closed) {
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
            default:
                return 0;
        }
    }

    public static void main(String[] args) {

    }
}
