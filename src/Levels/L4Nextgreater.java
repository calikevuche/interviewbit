package Levels;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by OlehKa on 30.10.2016.
 */
public class L4Nextgreater {

    public ArrayList<Integer> nextGreater(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a.size() == 0) return result;
        Stack<Integer> stack = new Stack<>();
        for (int i = a.size()-1; i >= 0; i--) {
            int element = a.get(i);
            while (!stack.isEmpty() && stack.peek() <= element) {
                stack.pop();
            }
            int nextGreater = stack.isEmpty() ? -1 : stack.peek();
            result.add(0, nextGreater);
            stack.push(element);
        }
        return result;
    }
}
