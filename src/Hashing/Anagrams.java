package Hashing;

import java.util.*;

/**
 * Created by OlehKa on 24.12.2016.
 */
public class Anagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            char[] chars = a.get(i).toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(i + 1);
            } else {
                map.put(key, new ArrayList<>(Arrays.asList(i + 1)));
            }
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (String s : map.keySet()) {
            res.add(map.get(s));
        }
        return res;
    }

    public static void main(String[] args) {
        Anagrams anagrams = new Anagrams();
        anagrams.anagrams(new ArrayList<>(Arrays.asList("cat", "dog", "god", "tca")));
    }
}
