package Graphs;

import java.util.*;

public class WordLadder2 {

    public ArrayList<ArrayList<String>> findLaddersV2(String start, String end, ArrayList<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        if ((start.isEmpty() && end.isEmpty()) ||
                (!start.isEmpty() && start.equals(end))) {
            result.add(new ArrayList<>(Arrays.asList(start)));
            return result;
        }
        if (isOneCharDiff(start.toCharArray(), end.toCharArray())) {
            result.add(new ArrayList<>(Arrays.asList(start, end)));
            return result;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(start);
        dfs(start, end, arrayList, dict, result);
        return result;
    }

    private boolean dfs(String word, String end, ArrayList<String> arrayList, ArrayList<String> dict, ArrayList<ArrayList<String>> result) {
        if (isOneCharDiff(word.toCharArray(), end.toCharArray())) {
            arrayList.add(end);
            return true;
        }
        for (int i = 0; i < dict.size(); i++) {
            if (!arrayList.contains(dict.get(i)) &&
                    isOneCharDiff(dict.get(i).toCharArray(), word.toCharArray())) {
                arrayList.add(dict.get(i));
                boolean ended = dfs(dict.get(i), end, arrayList, dict, result);
                if (ended) {
                    processResult(result, arrayList);
                    arrayList.remove(arrayList.size() - 1);
                }
                arrayList.remove(arrayList.size() - 1);
            }
        }
        return false;
    }

    private void processResult(ArrayList<ArrayList<String>> result, ArrayList<String> arrayList) {
        if (result.isEmpty()) {
            result.add(new ArrayList<>(arrayList));
        } else {
            int minSize = result.get(0).size();
            if (arrayList.size() < minSize) {
                result.clear();
                result.add(new ArrayList<>(arrayList));
            } else if (arrayList.size() == minSize
                    && !containsList(result, arrayList)) {
                result.add(new ArrayList<>(arrayList));
            }
        }
    }

    private boolean containsList(ArrayList<ArrayList<String>> result, ArrayList<String> list) {
        for (ArrayList<String> arrayList: result) {
            if (list.size() != arrayList.size()) {
                continue;
            }
            boolean hasAll = true;
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(arrayList.get(i))) {
                    hasAll = false;
                    break;
                }
            }
            if (hasAll) {
                return true;
            }
        }
        return false;
    }

    private boolean isOneCharDiff(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        int diff = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                diff++;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }

    public static void main(String[] args) {
        WordLadder2 ins = new WordLadder2();
        ins.findLaddersV2("hit", "cog", new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log")));
        ins.findLaddersV2("bb", "ab", new ArrayList<>(Arrays.asList("bb", "ab")));
        ins.findLaddersV2("aaaa", "bbbb", new ArrayList<>(Arrays.asList("baab", "abaa", "abab", "abab", "baba", "abbb", "bbab", "aabb", "abba")));
    }
}
