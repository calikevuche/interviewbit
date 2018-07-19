package Trees;

import java.util.*;

public class HotelReviews {

    // S - good_words, R - reviews

    public ArrayList<Integer> solve(String S, ArrayList<String> R) {

        // k - count, v - list of indexes
        TreeMap<Integer, ArrayList<Integer>> treeMap = new TreeMap<>();

        String[] goodWords = S.split("_");
        TrieNode root = new TrieNode();
        TrieNode current = null;
        TrieNode newNode = null;
        Character c = null;

        // create dictionary
        for (String word: goodWords) {
            current = root;
            for (int i = 0; i < word.length(); i++) {
                c = word.charAt(i);
                if (current.children.containsKey(c)) {
                    current = current.children.get(c);
                } else {
                    newNode = new TrieNode();
                    current.children.put(c, newNode);
                    current = newNode;
                }
                if (i == word.length() - 1) {
                    current.endOfWord = true;
                }
            }
        }

        // search words
        for (int i = 0; i < R.size(); i++) {
            String[] review = R.get(i).split("_");
            int count = 0;

            for (String w: review) {
                boolean exists = search(root, w);
                if (exists) {
                    count++;
                }
            }
            ArrayList<Integer> indexes = treeMap.getOrDefault(count, new ArrayList<>());
            indexes.add(i);
            treeMap.put(count, indexes);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int key: treeMap.descendingKeySet()) {
            result.addAll(treeMap.get(key));
        }
        return result;
    }

    private boolean search(TrieNode root, String word) {
        TrieNode current = root;
        Character c = null;
        for (int i = 0; i < word.length(); i++) {
            c = word.charAt(i);
            if (current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return false;
            }
        }
        return current.endOfWord;
    }

    public static void main(String[] args) {
        HotelReviews instance = new HotelReviews();
        instance.solve("cool_ice_wifi", new ArrayList<>(
                Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")
        ));
    }
}