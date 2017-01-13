package Hashing;

import java.util.*;

/**
 * Created by OlehKa on 02.01.2017.
 */
public class SubstringConcatenation {

    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a == null || b == null || a.length() == 0 || b.size() == 0) {
            return result;
        }
        HashMap<String, Integer> original = new HashMap<>();
        for (String s : b) {
            int val = 1;
            if (original.containsKey(s)) {
                val = original.get(s) + 1;
            }
            original.put(s, val);
        }
        HashMap<String, Integer> words = new HashMap<>();
        int len = b.get(0).length();
        StringBuilder sb = new StringBuilder(a);
        String sub = "";
        for (int i = 0; i < sb.length(); i ++) {
            words.clear();
            words.putAll(original);
            for (int j = i; j <= sb.length()-len; j += len) {
                sub = sb.substring(j, j+len);
                if (words.containsKey(sub) && words.get(sub) > 0) {
                    words.put(sub, words.get(sub)-1);
                    if (isEmpty(words)) {
                        result.add(i);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(result);
        return result;
    }

    public boolean isEmpty(HashMap<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SubstringConcatenation substringConcatenation = new SubstringConcatenation();
        substringConcatenation.findSubstring("barfoothefoobarman", new ArrayList<>(Arrays.asList("foo","bar")));
        substringConcatenation.findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", new ArrayList<>(Arrays.asList("aaa", "aaa", "aaa", "aaa", "aaa")));
    }
}
