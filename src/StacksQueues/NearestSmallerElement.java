package StacksQueues;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by OlehKa on 16.10.2016.
 */
public class NearestSmallerElement {

    public ArrayList<Integer> prevSmaller1(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr.size() == 0) return result;
        result.add(-1);
        for (int i = 1; i < arr.size(); i++) {
            int nearestSmaller = -1;
            int value = arr.get(i);
            for (int j = i-1; j >= 0; j--) {
                if (arr.get(j) < value) {
                    nearestSmaller = arr.get(j);
                    break;
                }
            }
            result.add(nearestSmaller);
        }
        return result;
    }

    public ArrayList<Integer> prevSmaller2(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack original = new Stack();
        if (arr.size() == 0) return result;
        result.add(-1);
        for (int i = 0; i < arr.size(); i++) {
            original.push(arr.get(i));
        }
        for (int i = 1; i < arr.size(); i++) {
            int value = (int) original.pop();
            Stack copy = (Stack) original.clone();
            int next = (int) copy.pop();
            while (next >= value && !copy.isEmpty()) {
                next = (int) copy.pop();
            }
            int nearestSmaller = next < value ? next : -1;
            result.add(1, nearestSmaller);
        }
        return result;
    }

    // THE BEST SOLUTION
    public ArrayList<Integer> prevSmaller3(ArrayList<Integer> arr) {
        ArrayList<Integer> result = new ArrayList<>();
        if (arr.size() == 0) return result;
        result.add(-1);
        Stack stack = new Stack();
        stack.push(arr.get(0));
        for (int i = 1; i < arr.size(); i++) {
            int value = arr.get(i);
            while (!stack.empty() && (int) stack.peek() >= value) {
                stack.pop();
            }
            int nearestSmaller = stack.empty() ? -1 : (int) stack.peek();
            result.add(nearestSmaller);
            stack.push(value);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
