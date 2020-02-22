package LeetCode_Easy;

import java.util.Arrays;

public class SquaresofaSortedArray977 {
    public static int[] sortedSquares(int[] A) {
        int[] B = new int[A.length];
        int index = A.length - 1;
        for (int i = 0, j = A.length - 1; index >= 0; ) {
            int left = A[i] * A[i];
            int right = A[j] * A[j];
            if (left <= right) {
                B[index] = right;
                j--;
            } else {
                B[index] = left;
                i++;
            }
            index--;
        }
        return B;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

}
