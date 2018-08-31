package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class KnightOnChessBoard {

    // board size (N * M), x - source, y - destination
    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        if (x2 == x1 && y2 == y1) {
            return 0;
        }
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = -1;
            }
        }
        board[x1 - 1][y1 - 1] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x1 - 1, y1 - 1));
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, -2, 2, 1, -1, -1, 1};
        int x, y;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                x = p.x + dx[i];
                y = p.y + dy[i];
                if (x >= 0 && x < N && y >= 0 && y < M && board[x][y] == -1) {
                    if (x == x2 - 1 && y == y2 - 1) {
                        return board[p.x][p.y] + 1;
                    }
                    queue.add(new Point(x, y));
                    board[x][y] = board[p.x][p.y] + 1;
                }
            }
        }
        return -1;
    }

    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        KnightOnChessBoard ins = new KnightOnChessBoard();
        ins.knight(8,8,1,1,8,8);
    }
}
