package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by OlehKa on 05.07.2016.
 */
public class PaintersPartitionProblem {

    //return minimum time to paint all boards % 10000003
    public int paint(int a, int b, ArrayList<Integer> c) {
        if (a == 0 || b == 0 || c.size() == 0) {
            return 0;
        }

        int maxElement = Collections.max(c);
        int sum = 0;
        for (int value : c) {
            sum += value;
            if (sum > 10000003) {
                sum = 10000003;
                break;
            }
        }

        int left = maxElement;
        int right = sum;

        while (left < right) {
            int mid = (left + right) / 2;
            if (isPossible(mid, a, c)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        long ans = (long)right * (long)b % 10000003;

        return (int) ans;
    }

    boolean isPossible(int time, int people, ArrayList<Integer> list) {

        int tempSum = 0;
        int counter = 1;

        for (int i = 0; i < list.size(); i++) {
            tempSum += list.get(i);
            if (tempSum > time) {
                tempSum = 0;
                i--;
                counter++;
            }
            if (counter > people) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PaintersPartitionProblem instance = new PaintersPartitionProblem();
//        System.out.println(instance.paint(3, 4, new ArrayList<>(Arrays.asList(10,4,8,9,6,5,1,2))));
        System.out.println(instance.paint(1, 1000000, new ArrayList<>(Arrays.asList(1000000, 1000000))));
    }
}
