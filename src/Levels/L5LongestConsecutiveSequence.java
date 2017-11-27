package Levels;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L5LongestConsecutiveSequence {

    public int longestConsecutive(final List<Integer> a) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int i : a) {
            if (map.containsKey(i))
                continue;
            map.put(i, 1);
            if (map.containsKey(i - 1))
                max = Math.max(max, merge(map, i - 1, i));
            if (map.containsKey(i + 1))
                max = Math.max(max, merge(map, i, i + 1));
        }
        return max;
    }

    public int merge(HashMap<Integer, Integer> map, int left, int right) {
        int upper = right + map.get(right) - 1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }

    public static void main(String[] args) {
        L5LongestConsecutiveSequence instance = new L5LongestConsecutiveSequence();
        instance.longestConsecutive(Arrays.asList(100, 4, 200, 1, 3, 2));
    }
}
