package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class PossibilityOfFinishingAllCourses {

    public static final int BLACK = 0;
    public static final int BLUE = 1;
    public static final int GREY = 2;

    // Topological sort:
    // return 1 (Yes), 0 (No)

    public int solve(int A, int[] B, int[] C) {
        boolean[] visited = new boolean[A];
        for (int i = 0; i < A; i++) {
            visited[i] = false;
        }
        Edge[] edges = new Edge[B.length];
        for (int i = 0; i < B.length; i++) {
            edges[i] = new Edge(B[i] - 1, C[i] - 1, 1);
        }
        int i = 0;
        while (i < A) {
            int courses = findNextCourses(edges, visited);
            if (courses == 0) {
                return 0;
            }
            i += courses;
        }
        return 1;
    }

    public int solve2(int A, int[] B, int[] C) {
        boolean[] visited = new boolean[A];
        ArrayList<Integer> adjacent[] = new ArrayList[A];
        for (int i = 0; i < A; i++) {
            visited[i] = false;
            adjacent[i] = new ArrayList<>();
        }
        for (int i = 0; i < B.length; i++) {
            adjacent[C[i] - 1].add(B[i] - 1);
        }
        int i = 0;
        while (i < A) {
            int courses = findNextCourses(adjacent, visited);
            if (courses == 0) {
                return 0;
            }
            i += courses;
        }
        return 1;
    }

    public int solve3(int A, int[] B, int[] C) {
        int[] visited = new int[A];
        ArrayList<Integer> adjacent[] = new ArrayList[A];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = BLACK;
            adjacent[i] = new ArrayList<>();
        }
        for (int i = 0; i < B.length; i++) {
            adjacent[B[i] - 1].add(C[i] - 1);
        }
        return hasCycle(visited[0], visited, adjacent) ? 0 : 1;
    }

    // Kahn
    public int solve4(int A, int[] B, int[] C) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> adjacent[] = new ArrayList[A];
        int[] indegree = new int[A];
        for (int i = 0; i < A; i++) {
            adjacent[i] = new ArrayList<>();
            indegree[i] = 0;
        }
        for (int i = 0; i < B.length; i++) {
            adjacent[B[i] - 1].add(C[i] - 1);
            indegree[C[i] - 1]++;
        }
        for (int i = 0; i < A; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int adj : adjacent[v]) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    queue.add(adj);
                }
            }
            count++;
        }
        return count == A ? 1 : 0;
    }

    // O(V * E)
    private int findNextCourses(Edge[] edges, boolean[] visited) {
        int result = 0;
        outer:
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                for (Edge edge : edges) {
                    if (edge.dest == i && !visited[edge.src]) {
                        continue outer;
                    }
                }
                visited[i] = true;
                result++;
            }
        }
        return result;
    }

    // O(V)
    private int findNextCourses(ArrayList<Integer> adjacent[], boolean[] visited) {
        int count = 0;
        outer:
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                for (int adj : adjacent[i]) {
                    if (!visited[adj]) {
                        continue outer;
                    }
                }
                visited[i] = true;
                count++;
            }
        }
        return count;
    }

    private boolean hasCycle(int v, int[] visited, ArrayList<Integer>[] adjacent) {
        if (visited[v] == BLUE) {
            return true;
        } else if (visited[v] == GREY) {
            return false;
        } else {
            visited[v] = BLUE;
        }
        for (int adj : adjacent[v]) {
            if (hasCycle(adj, visited, adjacent)) {
                return true;
            }
        }
        visited[v] = GREY;
        return false;
    }

    public static void main(String[] args) {
        PossibilityOfFinishingAllCourses instance = new PossibilityOfFinishingAllCourses();
        int A = 5;
        int[] B = {1, 3, 4, 5};
        int[] C = {2, 1, 5, 3};
        instance.solve(A, B, C);
    }
}
