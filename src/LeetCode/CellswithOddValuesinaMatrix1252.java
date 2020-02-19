package LeetCode;

public class CellswithOddValuesinaMatrix1252 {

    public static int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int idx = 0; idx < indices.length; idx++) {
            int row = indices[idx][0];
            int col = indices[idx][1];
            for (int i = 0; i < m; i++) {
                matrix[row][i]++;
            }
            for (int j = 0; j < n; j++) {
                matrix[j][col]++;
            }
        }
        int odd = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 != 0) {
                    odd++;
                }
            }
        }
        return odd;
    }

    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }

}
