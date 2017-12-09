package Trees;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestUniquePrefix {

    public ArrayList<String> prefix(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode node, next;

        // insert

        for (String word : words) {
            node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                } else {
                    next = new TrieNode();
                    node.children.put(c, next);
                    node = next;
                }
                if (i == word.length() - 1) {
                    node.endOfWord = true;
                }
            }
        }

        // search

        int endIndex;

        for (String word: words) {
            node = root;
            endIndex = -1;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node = node.children.get(c);
                if (endIndex == -1 &&
                        node.children.size() < 2) {
                    endIndex = i+1;
                }
                if (endIndex != -1 &&
                        node.children.size() > 1) {
                    endIndex = -1;
                }
            }
            result.add(word.substring(0, endIndex));
        }

        return result;
    }

    // solution with count

    public ArrayList<String> prefix2(ArrayList<String> words) {
        ArrayList<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        TrieNode node, next;

        // insert

        for (String word : words) {
            node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (node.children.containsKey(c)) {
                    node = node.children.get(c);
                    node.count++;
                } else {
                    next = new TrieNode();
                    node.children.put(c, next);
                    node = next;
                }
                if (i == word.length() - 1) {
                    node.endOfWord = true;
                }
            }
        }

        // search

        for (String word: words) {
            node = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                node = node.children.get(c);
                if (node.count == 1) {
                    result.add(word.substring(0, i+1));
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("bearcat", "bert"));
//        ArrayList<String> input = new ArrayList<>(Arrays.asList("zebra", "dog", "duck", "dove"));
        ShortestUniquePrefix instance = new ShortestUniquePrefix();
        System.out.println(instance.prefix2(input));
    }
}
