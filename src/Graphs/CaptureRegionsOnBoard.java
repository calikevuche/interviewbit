package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CaptureRegionsOnBoard {

    // 0 -> 'X', 1 -> 'O', 2 -> '?', 3 -> 'O'

    // slow
    public void solve(ArrayList<ArrayList<Character>> A) {
        int M = A.size(), N = A.get(0).size();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (A.get(i).get(j) == 'X') ? 0 : 1;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    doBFS(matrix, i, j);
                }
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0 && A.get(i).get(j) != 'X') {
                    A.get(i).set(j, 'X');
                }
            }
        }
    }

    // fast
    public void solve2(ArrayList<ArrayList<Character>> A) {
        int M = A.size(), N = A.get(0).size();
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = (A.get(i).get(j) == 'X') ? 0 : 1;
            }
        }
        for (int i = 0; i < M; i++) {
            if (matrix[i][0] == 1) {
                doBFSFromBoundary(matrix, i, 0);
            }
            if (matrix[i][N - 1] == 1) {
                doBFSFromBoundary(matrix, i, N - 1);
            }
        }
        for (int i = 0; i < N; i++) {
            if (matrix[0][i] == 1) {
                doBFSFromBoundary(matrix, 0, i);
            }
            if (matrix[M - 1][i] == 1) {
                doBFSFromBoundary(matrix, M - 1, i);
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 1) {
                    A.get(i).set(j, 'X');
                }
            }
        }
    }

    private void doBFS(int[][] matrix, int x, int y) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int M = matrix.length, N = matrix[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        boolean surrounded = true;
        while (!queue.isEmpty()) {
            Point p = queue.remove();
            for (int i = 0; i < 4; i++) {
                if (isValid(p.x + dx[i], p.y + dy[i], M, N) &&
                        matrix[p.x + dx[i]][p.y + dy[i]] == 1) {
                    queue.add(new Point(p.x + dx[i], p.y + dy[i]));
                }
            }
            matrix[p.x][p.y] = 2;
            if (surrounded &&
                    (p.x == 0 || p.x == M - 1 || p.y == 0 || p.y == N - 1)) {
                surrounded = false;
            }
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 2) {
                    matrix[i][j] = surrounded ? 0 : 3;
                }
            }
        }
    }

    private void doBFSFromBoundary(int[][] matrix, int x, int y) {
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        int M = matrix.length, N = matrix[0].length;

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            for (int i = 0; i < 4; i++) {
                if (isValid(p.x + dx[i], p.y + dy[i], M, N) &&
                        matrix[p.x + dx[i]][p.y + dy[i]] == 1) {
                    queue.add(new Point(p.x + dx[i], p.y + dy[i]));
                }
            }
            matrix[p.x][p.y] = 3;
        }
    }

    private boolean isValid(int x, int y, int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    public static void main(String[] args) {
        CaptureRegionsOnBoard instance = new CaptureRegionsOnBoard();
        ArrayList<ArrayList<Character>> A = new ArrayList<>();
        A.add(new ArrayList<>(Arrays.asList('X','O','X')));
        A.add(new ArrayList<>(Arrays.asList('X','O','X')));
        A.add(new ArrayList<>(Arrays.asList('X','O','X')));
        instance.solve(A);
    }
}
