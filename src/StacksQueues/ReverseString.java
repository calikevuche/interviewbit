package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 11.10.2016.
 */
public class ReverseString {

    public String reverseString(String a) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        char[] chars = a.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            char c = stack.pop();
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("abc"));
    }
}
