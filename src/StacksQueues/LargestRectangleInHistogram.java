package StacksQueues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by OlehKa on 22.10.2016.
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea1(ArrayList<Integer> A) {
        int result = 0;
        Stack<Integer> stack = new Stack<>(); // positions, NOT values
        int n = A.size();
        int leftMin[], rightMin[];
        leftMin = new int[n];
        rightMin = new int[n];
        int left, right;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                leftMin[i] = -1;
            } else {
                leftMin[i] = stack.peek();
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(i) <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                rightMin[i] = n;
            } else {
                rightMin[i] = stack.peek();
            }
            stack.push(i);
        }
        for (int i = 0; i < n; i++) {
            left = leftMin[i];
            right = rightMin[i];
            int area = (right - left - 1) * A.get(i);
            result = Math.max(result, area);
        }
        return result;
    }

    public int largestRectangleArea2(ArrayList<Integer> A) {
        int maxArea = 0;
        LinkedList<Integer> queue = new LinkedList<>(); // positions, NOT values
        int[] passedBars = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            passedBars[i] = 0;
        }
        for (int i = 0; i < A.size(); i++) {
            if (passedBars[i] == 1) {
                continue;
            }
            int height = A.get(i);
            for (int j = 0; j < A.size(); j++) {
                if (A.get(j) >= height) {
                    if (A.get(j) == height) {
                        passedBars[j] = 1;
                    }
                    queue.add(j);
                }
            }
            int width = maxWidth(queue);
            if (height * width > maxArea) {
                maxArea = height * width;
            }
        }
        return maxArea;
    }

    private int maxWidth(LinkedList<Integer> queue) {
        if (queue == null || queue.isEmpty()) {
            return 0;
        }
        int prev = queue.pollFirst();
        int maxWidth = 1;
        int tempWidth = 1;
        while (!queue.isEmpty()) {
            int cur = queue.pollFirst();
            if (cur - prev == 1) {
                tempWidth++;
            } else {
                if (tempWidth > maxWidth) {
                    maxWidth = tempWidth;
                }
                tempWidth = 1;
            }
            prev = cur;
        }
        if (tempWidth > maxWidth) {
            maxWidth = tempWidth;
        }
        return maxWidth;
    }

    // the best
    public int largestRectangleArea3(ArrayList<Integer> A) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int left, right, height;
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && A.get(i) < A.get(stack.peek())) {
                height = A.get(stack.pop());
                left = stack.isEmpty() ? -1 : stack.peek();
                right = i;
                maxArea = Math.max(maxArea, (right - left - 1) * height);
            }
            stack.push(i);
        }
        right = A.size();
        while (!stack.isEmpty()) {
            height = A.get(stack.pop());
            left = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (right - left - 1) * height);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3));
        LargestRectangleInHistogram ins = new LargestRectangleInHistogram();
        ins.largestRectangleArea3(arrayList);
    }
}
