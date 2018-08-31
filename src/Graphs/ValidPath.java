package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ValidPath {

    public static final int INITIALIZED = 0;
    public static final int VISITED = 1;
    public static final int PROHIBITED = 2;

    public static final String YES = "YES";
    public static final String NO = "NO";

    public String solve(int A, int B, int C, int D, ArrayList<Integer> E, ArrayList<Integer> F) {
        return solve(A, B, C, D, toArray(E), toArray(F));
    }

    private int[] toArray(ArrayList<Integer> arrayList) {
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    private String solve(int A, int B, int C, int D, int[] E, int[] F) {
        int[][] matrix = new int[A + 1][B + 1];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = INITIALIZED;
            }
        }

        for (int i = 0; i < C; i++) {
            Point start = new Point(E[i] - D, F[i] - D);
            if (D == 0) {
                matrix[start.x][start.y] = PROHIBITED;
            } else {
                for (int j = 0; j < D * 2 + 1; j++) {
                    for (int k = 0; k < D * 2 + 1; k++) {
                        int x = start.x + j;
                        int y = start.y + k;
                        if (x < 0 || x > A || y < 0 || y > B) {
                            continue;
                        }
                        if (calcDistance(E[i], F[i], x, y) <= D * D) {
                            matrix[x][y] = PROHIBITED;
                        }
                    }
                }
            }
        }

        if (matrix[0][0] == PROHIBITED || matrix[A][B] == PROHIBITED) {
            return NO;
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point cur = queue.remove();
            if (cur.x < 0 || cur.x > A || cur.y < 0 || cur.y > B ||
                    matrix[cur.x][cur.y] == VISITED ||
                    matrix[cur.x][cur.y] == PROHIBITED) {
                continue;
            }
            matrix[cur.x][cur.y] = VISITED;

            queue.add(new Point(cur.x - 1, cur.y - 1));
            queue.add(new Point(cur.x + 1, cur.y + 1));

            queue.add(new Point(cur.x - 1, cur.y + 1));
            queue.add(new Point(cur.x + 1, cur.y - 1));

            queue.add(new Point(cur.x, cur.y + 1));
            queue.add(new Point(cur.x, cur.y - 1));

            queue.add(new Point(cur.x + 1, cur.y));
            queue.add(new Point(cur.x - 1, cur.y));
        }
        return matrix[A][B] == VISITED ? YES : NO;
    }

    private long calcDistance(int x1, int y1, int x2, int y2) {
        return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0, 1, 1, 0, 0));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(58, 68, 52, 13, 35));
        ValidPath instance = new ValidPath();
        instance.solve(2, 73,5, 1, list1, list2);
    }
}
