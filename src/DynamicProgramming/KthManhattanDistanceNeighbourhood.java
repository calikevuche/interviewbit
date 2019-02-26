package DynamicProgramming;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthManhattanDistanceNeighbourhood {

    public int[][] solve(int K, int[][] M) {
        int rows = M.length, cols = M[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = -1;
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        initQueue(K, M, queue);
        result[0][0] = queue.peek();

        boolean leftToRight = true;
        for (int i = 0; i < rows; i++) {
            if (leftToRight) {
                for (int j = 0; j < cols; j++) {
                    if (i == 0 && j == 0) continue;
                    moveRight(K, M, queue);
                    result[i][j] = queue.peek();
                }
            } else {
                for (int j = cols - 1; j >= 0; j--) {
                    moveLeft(K, M, queue);
                    result[i][j] = queue.peek();
                }
            }
            moveDown(K, M, queue);
            leftToRight = !leftToRight;
        }
        return result;
    }

    private void initQueue(int K, int[][] M, Queue<Integer> queue) {
        int step = K + 1;
        for (int i = 0; i < K + 1; i++) {
            for (int j = 0; j < step; j++) {
                if (i < M.length && j < M[0].length) {
                    queue.add(M[i][j]);
                }
            }
            step--;
        }
    }

    private void moveRight(int K, int[][] M, PriorityQueue<Integer> queue) {
    }

    private void moveLeft(int K, int[][] M, PriorityQueue<Integer> queue) {
    }

    private void moveDown(int K, int[][] M, PriorityQueue<Integer> queue) {
    }


    public int[][] solve2(int K, int[][] M) {
        int rows = M.length, cols = M[0].length;
        int[][][] result = new int[K + 1][rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[0][i][j] = M[i][j];
            }
        }

        for (int i = 1; i < K + 1; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < cols; k++) {

                    result[i][j][k] = result[i - 1][j][k];

                    //up
                    if (j > 0 && result[i - 1][j - 1][k] > result[i][j][k]) {
                        result[i][j][k] = result[i - 1][j - 1][k];
                    }

                    //down
                    if (j < rows - 1 && result[i - 1][j + 1][k] > result[i][j][k]) {
                        result[i][j][k] = result[i - 1][j + 1][k];
                    }

                    //left
                    if (k > 0 && result[i - 1][j][k - 1] > result[i][j][k]) {
                        result[i][j][k] = result[i - 1][j][k - 1];
                    }

                    //right
                    if (k < cols - 1 && result[i - 1][j][k + 1] > result[i][j][k]) {
                        result[i][j][k] = result[i - 1][j][k + 1];
                    }
                }
            }
        }

        return result[K];
    }


    public static void main(String[] args) {
        KthManhattanDistanceNeighbourhood ins = new KthManhattanDistanceNeighbourhood();
        int[][] t1 = ins.solve2(2, new int[][]{{1, 2, 4}, {4, 5, 8}, {3, 7, 9}});
        System.out.println(t1);
    }
}
