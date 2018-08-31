package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BlackShapes {

    public int black(String[] A) {
        int count = 0;
        int M = A.length, N = A[0].length();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (A[i].charAt(j) == 'X') ? 1 : 0;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    doBFS(matrix, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void doBFS(int[][] matrix, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            if (p.x - 1 >= 0 && matrix[p.x - 1][p.y] == 1) {
                queue.add(new Point(p.x - 1, p.y));
            }
            if (p.x + 1 < matrix.length && matrix[p.x + 1][p.y] == 1) {
                queue.add(new Point(p.x + 1, p.y));
            }
            if (p.y - 1 >= 0 && matrix[p.x][p.y - 1] == 1) {
                queue.add(new Point(p.x , p.y - 1));
            }
            if (p.y + 1 < matrix[0].length && matrix[p.x][p.y + 1] == 1) {
                queue.add(new Point(p.x, p.y + 1));
            }
            matrix[p.x][p.y] = 0;
        }
    }
}
