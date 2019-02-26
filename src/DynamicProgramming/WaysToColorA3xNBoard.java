package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class WaysToColorA3xNBoard {

    // 4 colors

    public int solve(int N) {
        int[][] board = new int[3][N];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = -1;
            }
        }
        int[][] cache = new int[2][N];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                cache[i][j] = -1;
            }
        }
        return solve2(board, cache, 0);
    }

    private int solve(int[][] board, int x, int y) {
        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (checkColor(board, x, y, i)) {
                board[x][y] = i;
                if (y < board[0].length - 1) {
                    result += solve(board, x, y + 1);
                } else if (x < board.length - 1) {
                    result += solve(board, x + 1, 0);
                } else {
                    result += 1;
                }
                result %= 1000000007;
            }
        }
        board[x][y] = -1;
        return result;
    }

    private boolean checkColor(int[][] board, int x, int y, int color) {
        if (x > 0 && board[x - 1][y] == color) {
            return false;
        }
        if (y > 0 && board[x][y - 1] == color) {
            return false;
        }
        return true;
    }

    private int solve2(int[][] board, int[][] cache, int x) {
        if (x == board[0].length) {
            return 1;
        }
        int sameColorId = (x > 0 && board[0][x - 1] == board[2][x - 1]) ? 1 : 0;
        if (cache[sameColorId][x] != -1) {
            return cache[sameColorId][x];
        }

        int result = 0;
        for (int i = 0; i < 4; i++) {
            if (x > 0 && board[0][x - 1] == i) continue;
            board[0][x] = i;
            for (int j = 0; j < 4; j++) {
                if (x > 0 && board[1][x - 1] == j) continue;
                if (board[0][x] == j) continue;
                board[1][x] = j;
                for (int k = 0; k < 4; k++) {
                    if (x > 0 && board[2][x - 1] == k) continue;
                    if (board[1][x] == k) continue;
                    board[2][x] = k;
                    result += solve2(board, cache, x + 1);
                    result %= 1000000007;
                }
            }
        }
        board[0][x] = -1;
        board[1][x] = -1;
        board[2][x] = -1;
        cache[sameColorId][x] = result;
        return result;
    }

    class Triplet {
        int x = 0; int y = 0; int z = 0;
        public Triplet(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


    public int solve3(int N) {
        List<Triplet> triplets = getTriplets();

        int[][][][] cache = new int[4][4][4][N];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < N; l++) {
                        cache[i][j][k][l] = -1;
                    }
                }
            }
        }

        int result = 0, temp = 0;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < triplets.size(); j++) {
                Triplet t1 = triplets.get(j);
                if (i == 0) {
                    cache[t1.x][t1.y][t1.z][i] = 1;
                    continue;
                }

                temp = 0;
                for (int k = 0; k < triplets.size(); k++) {
                    Triplet t2 = triplets.get(k);
                    if (compareTriplets(t1, t2)) {
                        temp += cache[t2.x][t2.y][t2.z][i - 1];
                        temp %= 1000000007;
                    }
                }
                cache[t1.x][t1.y][t1.z][i] = temp;
            }
        }

        for (int i = 0; i < triplets.size(); i++) {
            Triplet t = triplets.get(i);
            result += cache[t.x][t.y][t.z][N - 1];
            result %= 1000000007;
        }

        return result;
    }

    private List<Triplet> getTriplets() {
        List<Triplet> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i != j && j != k) {
                        list.add(new Triplet(i, j, k));
                    }
                }
            }
        }
        return list;
    }

    private boolean compareTriplets(Triplet t1, Triplet t2) {
        return t1.x != t2.x && t1.y != t2.y && t1.z != t2.z;
    }


    public static void main(String[] args) {
        WaysToColorA3xNBoard ins = new WaysToColorA3xNBoard();
        int t1 = ins.solve3(1);
        int t2 = ins.solve3(2);
        int t3 = ins.solve3(3);
        int t4 = ins.solve(100);
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
    }
}
