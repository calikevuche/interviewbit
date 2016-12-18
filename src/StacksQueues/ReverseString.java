package StacksQueues;

import java.util.Stack;

/**
 * Created by OlehKa on 11.10.2016.
 */
public class ReverseString {

    public String reverseString(String a) {
        String result = "";
        Stack stack = new Stack();
        char[] chars = a.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            char c = (char) stack.pop();
            result += c;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString("abc"));
    }
}
