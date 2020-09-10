package LeetCode_Easy;

public class LeetCode_1572_MatrixDiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int a = 0;
        int b = mat[0].length - 1;
        for (int i = 0; i < mat.length; i++) {
            if (a == b) {
                sum += mat[i][a];
                a++;
                b--;
                continue;
            }
            sum += mat[i][a];
            sum += mat[i][b];
            a++;
            b--;
        }
        return sum;
    }
}
