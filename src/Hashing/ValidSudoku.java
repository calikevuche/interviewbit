package Hashing;

import java.util.*;

public class ValidSudoku {


    //Return 0 / 1 ( 0 for false, 1 for true )

    public int isValidSudoku(final List<String> A) {
        int size = 9;
        if (A.size() != size) {
            return 0;
        }
        for (String s : A) {
            if (s.length() != size) {
                return 0;
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    continue;
                }
                if (s.charAt(i) < '1' || s.charAt(i) > '9') {
                    return 0;
                }
            }
        }

        HashMap<Integer, HashSet<Integer>> horizontals = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> verticals = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> regions = new HashMap<>();
        initMap(horizontals, size);
        initMap(verticals, size);
        initMap(regions, size);

        HashSet<Integer> hashSet;

        int num = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (A.get(i).charAt(j) == '.') {
                    continue;
                }
                num = A.get(i).charAt(j) - '0';

                hashSet = horizontals.get(i);
                if (hashSet.contains(num)) {
                    return 0;
                } else {
                    hashSet.add(num);
                }

                hashSet = verticals.get(j);
                if (hashSet.contains(num)) {
                    return 0;
                } else {
                    hashSet.add(num);
                }

                hashSet = regions.get(3 * (i / 3) + j / 3);
                if (hashSet.contains(num)) {
                    return 0;
                } else {
                    hashSet.add(num);
                }
            }
        }

        return 1;
    }

    private void initMap(HashMap<Integer, HashSet<Integer>> map, int size) {
        for (int i = 0; i < size; i++) {
            map.put(i, new HashSet<>());
        }
    }

    public static void main(String[] args) {
        ValidSudoku ins = new ValidSudoku();
        ins.isValidSudoku(new ArrayList<>(Arrays.asList(
                "..5.....6", "....14...", ".........", ".....92..", "5....2...", ".......3.", "...54....", "3.....42.", "...27.6.."
        )));
    }
}
