package Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by OlehKa on 28.07.2016.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> arrayList) {
        int minStrIndex = 0;
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i).length() < arrayList.get(minStrIndex).length()) minStrIndex = i;
        }
        StringBuilder prefix = new StringBuilder();
        String minStr = arrayList.get(minStrIndex);
        char[] minStrArr = minStr.toCharArray();
        for (int i = 0; i < minStrArr.length; i++) {
            char c = minStrArr[i];
            for (int j = 0; j < arrayList.size(); j++) {
                if (arrayList.get(j).toCharArray()[i] != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix instance = new LongestCommonPrefix();
        System.out.println(instance.longestCommonPrefix(new ArrayList<>(Arrays.asList("aa", "ab"))));
        System.out.println(instance.longestCommonPrefix(new ArrayList<>(Arrays.asList("aaa", "aab"))));
        System.out.println(instance.longestCommonPrefix(new ArrayList<>(Arrays.asList("aaa", "aaa"))));
        System.out.println(instance.longestCommonPrefix(new ArrayList<>(Arrays.asList("aaa", ""))));
        System.out.println(instance.longestCommonPrefix(new ArrayList<>(Arrays.asList("", ""))));
        System.out.println(instance.longestCommonPrefix(new ArrayList<>(Arrays.asList("a", "a"))));
    }
}
