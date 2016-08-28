package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 05.06.2016.
 */
public class MaxNonNegativeSubArray {

    public ArrayList<Integer> maxset(ArrayList<Integer> a) {
        ArrayList<Integer> maxList = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList.add(0);
        boolean reachNegative = false;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) >= 0) {
                if (reachNegative) {
                    reachNegative = false;
                    tempList.add(i);
                }
                tempList.add(a.get(i));
            } else {
                if (!reachNegative && compare(tempList, maxList) == 1) {
                    maxList.clear();
                    maxList.addAll(tempList);
                }
                tempList.clear();
                reachNegative = true;
            }
        }
        if (compare(tempList, maxList) == 1) {
            maxList.clear();
            maxList.addAll(tempList);
            tempList.clear();
        }
        if (maxList.size() == 0) return maxList;
        return new ArrayList<>(maxList.subList(1, maxList.size()));
    }

    public long sum(ArrayList<Integer> a) {
        long result = 0;
        for (int i = 1; i < a.size(); i++) {
            result += a.get(i);
        }
        return result;
    }

    public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
        long sumA = sum(a);
        long sumB = sum(b);

        if (sumA > sumB)  return 1;
        else if (sumA < sumB) return -1;
        else if (sumA == sumB) {
            int lengthA = a.size();
            int lengthB = b.size();
            if (lengthA > lengthB) return 1;
            else if (lengthA < lengthB) return -1;
            else if (lengthA == lengthB) {
                if (lengthA == 0 || lengthB == 0) return 0;
                int startA = a.get(0);
                int startB = b.get(0);
                return Integer.compare(startB, startA);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        MaxNonNegativeSubArray instance = new MaxNonNegativeSubArray();
//        System.out.println(instance.maxset(new ArrayList<>(Arrays.asList(-846930886, -1714636915, 424238335, -1649760492))));
//        System.out.println(instance.maxset(new ArrayList<>(Arrays.asList(1, 2, 5, -7, 2, 3))));
//        System.out.println(instance.maxset(new ArrayList<>(Arrays.asList( -1, -1, -1, -1, -1 ))));
//        System.out.println(instance.maxset(new ArrayList<>(Arrays.asList( 1967513926, 1540383426, -1303455736, -521595368 ))));
//        System.out.println(instance.maxset(new ArrayList<>(Arrays.asList( 756898537, -1973594324, -2038664370, -184803526, 1424268980 ))));
        System.out.println(instance.maxset(new ArrayList<>(Arrays.asList( 24115, -75629, -46517, 30105, 19451, -82188, 99505, 6752, -36716, 54438, -51501, 83871, 11137, -53177, 22294, -21609, -59745, 53635, -98142, 27968, -260, 41594, 16395, 19113, 71006, -97942, 42082, -30767, 85695, -73671 ))));
    }
}
