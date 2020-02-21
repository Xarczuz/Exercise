package LeetCode_Easy;

import java.util.Arrays;

public class FlippinganImage832 {
    public static int[][] flipAndInvertImage(int[][] A) {
        for (int i = 0; i < A.length; i++) {
            int[] tmp = new int[A[0].length];
            for (int j = 0, g = A[0].length - 1; j < A[0].length; j++, g--) {
                tmp[j] = A[i][g] ^ 1;
            }
            A[i] = tmp;
        }
        return A;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
    }
}
