package Hashing;

import java.util.*;

/**
 * Created by OlehKa on 01.01.2017.
 */
public class PointsOnTheStraightLine {

    private HashMap<Double, Integer> hashMap;

    public int maxPoints(ArrayList<Integer> A, ArrayList<Integer> B) {

        hashMap = new HashMap<>();

        if (A == null || B == null)
            return -1;

        if (A.size() == 0)
            return 0;

        int n = A.size();
        int x1, y1, x2, y2;
        int val;
        int max = 0;

        for (int i = 0; i < n; i++) {

            x1 = A.get(i);
            y1 = B.get(i);
            hashMap.clear();

            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                x2 = A.get(j);
                y2 = B.get(j);

                double slope = y2 - y1;
                int den = x2 - x1;

                if (den == 0)
                    slope = Double.POSITIVE_INFINITY;
                else
                    slope = slope / den;

                val = 1;

                if (hashMap.containsKey(slope)) {
                    val = hashMap.get(slope) + 1;
                }

                hashMap.put(slope, val);

            }

            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                val = entry.getValue();
                max = Math.max(max, val);
            }
        }

        System.out.println(max + 1);

        return max + 1;
    }

    public static void main(String[] args) {
        PointsOnTheStraightLine pointsOnTheStraightLine = new PointsOnTheStraightLine();
        pointsOnTheStraightLine.maxPoints(new ArrayList<>(Arrays.asList(2,3,3,5,5,6,8,8)), new ArrayList<>(Arrays.asList(2,5,8,3,6,6,3,6)));
        pointsOnTheStraightLine.maxPoints(new ArrayList<>(Arrays.asList(2,3)), new ArrayList<>(Arrays.asList(2,3)));
        pointsOnTheStraightLine.maxPoints(new ArrayList<>(Arrays.asList(1,2,3,1,1,1)), new ArrayList<>(Arrays.asList(1,2,3,1,1,1)));
        pointsOnTheStraightLine.maxPoints(
                new ArrayList<>(Arrays.asList(18, 15, -10, 15, -11, 4, 13, -7, 5, -4, 3, -12, 20, -18, 19, -4, -13, -11, 10, 1, -8)),
                new ArrayList<>(Arrays.asList(-3, 14, -9, 18, 14, 17, -18, 1, -18, -18, 18, 3, -16, 12, -2, -15, 2, 20, -14, 19, 10)));
    }
}
