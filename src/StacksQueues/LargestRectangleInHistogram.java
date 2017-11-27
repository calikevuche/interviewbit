package StacksQueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by OlehKa on 22.10.2016.
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        int n = A.size();
        int res = 0;
        int prevMin[], nextMin[];
        int cur;
        int prev, next;

        prevMin = new int[n];
        nextMin = new int[n];

        for (int i = 0; i < n; i++) {
            cur = A.get(i);
            while (!stack.isEmpty() && cur <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                prevMin[i] = -1;
            } else {
                prevMin[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            cur = A.get(i);
            while (!stack.isEmpty() && cur <= A.get(stack.peek())) {
                stack.pop();
            }
            if (stack.isEmpty())
                nextMin[i] = n;
            else
                nextMin[i] = stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            prev = prevMin[i];
            next = nextMin[i];
            int area = (next - prev - 1) * A.get(i);
            res = Math.max(res, area);
        }

        return res;
    }

    public int largestRectangleArea1(ArrayList<Integer> a) {
        int maxArea = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] passedBars = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            passedBars[i] = 0;
        }
        for (int i = 0; i < a.size(); i++) {
            if (passedBars[i] == 1) continue;
            int height = a.get(i);
            for (int j = 0; j < a.size(); j++) {
                if (a.get(j) >= height) {
                    if (a.get(j) == height) passedBars[j] = 1;
                    queue.add(j);
                }
            }
            int width = maxWidth(queue);
            if (height * width > maxArea) maxArea = height * width;
        }
        return maxArea;
    }

    private int maxWidth(LinkedList<Integer> list) {
        if (list.isEmpty()) return 0;
        int prev = list.pollFirst();
        int maxWidth = 1;
        int tempWidth = 1;
        while (!list.isEmpty()) {
            int first = list.pollFirst();
            if (first - prev == 1) {
                tempWidth++;
            } else {
                if (tempWidth > maxWidth) maxWidth = tempWidth;
                tempWidth = 1;
            }
            prev = first;
        }
        if (tempWidth > maxWidth) maxWidth = tempWidth;
        return maxWidth;
    }

    public static void main(String[] args) {
    }
}
