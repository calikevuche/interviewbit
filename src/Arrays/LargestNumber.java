package Arrays;

import java.util.*;

/**
 * Created by OlehKa on 01.06.2016.
 */
public class LargestNumber {

    static final Comparator<Integer> LARGEST_ORDER = (o1, o2) -> {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(o1).append(o2);
        Long XY = Long.valueOf(stringBuilder.toString());
        stringBuilder.delete(0, stringBuilder.length());
        stringBuilder.append(o2).append(o1);
        Long YX = Long.valueOf(stringBuilder.toString());
        return YX.compareTo(XY);
    };

    static final Comparator<Integer> LARGEST_ORDER_SIMPLE = (o1, o2) -> {
        String XY = String.valueOf(o1) + String.valueOf(o2);
        String YX = String.valueOf(o2) + String.valueOf(o1);
        return YX.compareTo(XY);
    };

    // DO NOT MODIFY THE LIST
    public String largestNumber(final List<Integer> a) {
        List<Integer> sortedList = new ArrayList<>(a);
        Collections.sort(sortedList, LARGEST_ORDER_SIMPLE);
        StringBuilder stringBuilder = new StringBuilder();
        boolean isZero = true;
        for(Integer value: sortedList) {
            if (isZero && value != 0) isZero = false;
            stringBuilder.append(value);
        }
        if (isZero) return "0";
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        LargestNumber instance = new LargestNumber();
        List<Integer> list = Arrays.asList(3, 30, 34, 5, 9);
//        List<Integer> list = Arrays.asList(27, 271, 12, 121);
        System.out.println(instance.largestNumber(list));
    }
}
