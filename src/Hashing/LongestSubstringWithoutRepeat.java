package Hashing;

import java.util.HashSet;

/**
 * Created by OlehKa on 26.12.2016.
 */
public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String a) {
        if (a.length() == 0) return 0;

        int left = 0, right = 0, res = 0;
        char[] chars = a.toCharArray();
        HashSet<Character> set = new HashSet<>();
        while (right < chars.length) {
            if (set.contains(chars[right])) {
                if (right - left > res) res = right - left;
                set.remove(chars[left]);
                left++;
            } else {
                set.add(chars[right]);
                right++;
            }
        }
        if (right - left > res) res = right - left;

        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat longestSubstringWithoutRepeat = new LongestSubstringWithoutRepeat();
        int res = longestSubstringWithoutRepeat.lengthOfLongestSubstring("abcdabcda");
        System.out.println(res);
    }
}
