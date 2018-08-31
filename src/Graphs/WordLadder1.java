package Graphs;

import java.util.*;

public class WordLadder1 {

    public int ladderLengthV2(String start, String end, ArrayList<String> dict) {
        if (start.isEmpty() && end.isEmpty()) {
            return 1;
        }
        if (!start.isEmpty() && start.equals(end)) {
            return 1;
        }
        int[] visited = new int[dict.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }
        int shortestLength = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(queue);
            queue.clear();
            for (String w: arrayList) {
                if (isOneCharDiff(w.toCharArray(), end.toCharArray())) {
                    return shortestLength + 1;
                }
                for (int i = 0; i < dict.size(); i++) {
                    if (visited[i] == 0 &&
                            isOneCharDiff(w.toCharArray(), dict.get(i).toCharArray())) {
                        queue.add(dict.get(i));
                        visited[i] = 1;
                    }
                }
            }
            shortestLength++;
        }
        return 0;
    }

    public int ladderLengthV1(String start, String end, ArrayList<String> dict) {
        if (start.isEmpty() && end.isEmpty()) {
            return 1;
        }
        if (!start.isEmpty() && start.equals(end)) {
            return 1;
        }

        dict.add(0, start);
        dict.add(1, end);

        int[] visited = new int[dict.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        HashMap<Integer, Node> hashMap = new HashMap<>();
        Node node;
        for (int i = 0; i < dict.size(); i++) {
            if (hashMap.containsKey(i)) {
                node = hashMap.get(i);
            } else {
                node = new Node(i);
                hashMap.put(i, node);
            }
            node.nodes.addAll(getTransformList(dict.get(i), dict, visited));
        }

        if (visited[1] == 0) {
            return 0;
        }
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            node = hashMap.get(cur);
            for (int id: node.nodes) {
                if (id == 1) {
                    return visited[cur] + 1;
                }
                if (visited[id] == 0) {
                    queue.add(id);
                    visited[id] = visited[cur] + 1;
                }
            }
        }

        return 0;
    }

    private ArrayList<Integer> getTransformList(String word, ArrayList<String> dict, int[] visited) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < dict.size(); i++) {
            if (isOneCharDiff(word.toCharArray(), dict.get(i).toCharArray())) {
                result.add(i);
                visited[i] = 1;
            }
        }
        return result;
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

    class Node {
        int id;
        ArrayList<Integer> nodes;

        Node(int id) {
            this.id = id;
            nodes = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        WordLadder1 ins = new WordLadder1();
        ArrayList<String> dict = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log"));
        ins.ladderLengthV2("hit", "cog", dict);
    }
}
