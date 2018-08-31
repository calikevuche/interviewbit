package Graphs;

import java.util.*;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap = new HashMap<>();
        HashSet<UndirectedGraphNode> visitedSet = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.add(node);
        UndirectedGraphNode clone = null, cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (visitedSet.contains(cur)) {
                continue;
            }
            visitedSet.add(cur);
            if (clone == null) {
                clone = new UndirectedGraphNode(cur.label);
                hashMap.put(cur, clone);
            }
            copyNeighbors(cur, hashMap.get(cur), hashMap);
            for (int i = 0; i < cur.neighbors.size(); i++) {
                UndirectedGraphNode n = cur.neighbors.get(i);
                if (!visitedSet.contains(n)) {
                    queue.add(n);
                }
            }
        }
        return clone;
    }

    private void copyNeighbors(UndirectedGraphNode source, UndirectedGraphNode target,
                               HashMap<UndirectedGraphNode, UndirectedGraphNode> hashMap) {
        for (int i = 0; i < source.neighbors.size(); i++) {
            UndirectedGraphNode n1 = source.neighbors.get(i);
            UndirectedGraphNode n2 = null;
            if (hashMap.containsKey(n1)) {
                n2 = hashMap.get(n1);
            } else {
                n2 = new UndirectedGraphNode(n1.label);
                hashMap.put(n1, n2);
            }
            target.neighbors.add(n2);
        }
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<>();
        }
    }
}
