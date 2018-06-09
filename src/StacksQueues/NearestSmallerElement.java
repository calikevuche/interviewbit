package StacksQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by OlehKa on 16.10.2016.
 */
public class NearestSmallerElement {

    // Naive
    public ArrayList<Integer> prevSmaller1(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            int nearestSmaller = -1;
            int value = arr.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j) < value) {
                    nearestSmaller = arr.get(j);
                    break;
                }
            }
            result.add(nearestSmaller);
        }
        return result;
    }

    // Better
    public ArrayList<Integer> prevSmaller3(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int val : arr) {
            while (!stack.empty() && stack.peek() >= val) {
                stack.pop();
            }
            int nearestSmaller = stack.empty() ? -1 : stack.peek();
            result.add(nearestSmaller);
            stack.push(val);
        }
        return result;
    }
}
