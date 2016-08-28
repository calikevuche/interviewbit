package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 27.08.2016.
 */
public class ContainerWithMostWater {

    // slow solution
    public int maxArea1(ArrayList<Integer> a) {
        int result = 0;
        for (int i = 0; i < a.size()-1; i++) {
            for (int j = i+1; j < a.size(); j++) {
                int width = j-i;
                int height = Math.min(a.get(i), a.get(j));
                int area = width * height;
                if (area > result) result = area;
            }
        }
        return result;
    }

    // better solution
    public int maxArea(ArrayList<Integer> a) {
        int result = 0;
        int start = 0, end = a.size()-1;
        while (start <= end) {
            int width = end-start;
            int height = Math.min(a.get(start), a.get(end));
            int area = width * height;
            if (area > result) result = area;
            if (a.get(start) < a.get(end)) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ContainerWithMostWater instance = new ContainerWithMostWater();
        System.out.println(instance.maxArea(new ArrayList<>(Arrays.asList(1, 5, 4, 3))));
        System.out.println(instance.maxArea(new ArrayList<>(Arrays.asList(1,2))));
    }
}
