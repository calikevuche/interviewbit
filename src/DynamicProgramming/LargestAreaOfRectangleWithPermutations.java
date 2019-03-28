package DynamicProgramming;

public class LargestAreaOfRectangleWithPermutations {

    public int solve(int[][] A) {
        int maxArea = 0;
        int m = A.length;
        int n = A[0].length;
        int[][] hist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                hist[i][j] = 0;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 1) {
                    hist[i][j] = (i == 0) ? 1 : hist[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int[] row = sortCount(hist[i], m + 1);
            int start = row.length - 1, end = row.length;
            int width, height, area = 0;
            for (int j = row.length - 2; j >= 0; j--) {
                if (row[j] != row[start]) {
                    width = end - start;
                    height = row[start];
                    area = width * height;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
                start = j;
            }
            if (start == 0) {
                width = end - start;
                height = row[start];
                area = width * height;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int[] sortCount(int[] A, int range) {
        int[] output = new int[A.length + 1];
        int[] countArr = new int[range];
        for (int i = 0; i < range; i++) {
            countArr[i] = 0;
        }
        for (int i = 0; i < A.length; i++) {
            countArr[A[i]]++;
        }
        for (int i = 1; i < range; i++) {
            countArr[i] = countArr[i] + countArr[i - 1];
        }
        for (int i = 0; i < A.length; i++) {
            output[countArr[A[i]]] = A[i];
            countArr[A[i]]--;
        }
        return output;
    }

    public static void main(String[] args) {
        LargestAreaOfRectangleWithPermutations ins = new LargestAreaOfRectangleWithPermutations();
        int t1 = ins.solve(new int[][]{{1, 0, 1}, {0, 1, 0}, {1, 0, 0}});
        System.out.println(t1);
        int t2 = ins.solve(new int[][]{{0, 1, 0, 1, 0}, {0, 1, 1, 1, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}});
        System.out.println(t2);
        int t3 = ins.solve(new int[][]{{1, 0, 1}, {1, 0, 1}, {1, 0, 1}});
        System.out.println(t3);
    }
}
