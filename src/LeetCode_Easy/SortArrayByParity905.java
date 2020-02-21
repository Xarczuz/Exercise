package LeetCode_Easy;

import java.util.Arrays;

public class SortArrayByParity905 {

    public static int[] sortArrayByParity(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0, j = 0, g = A.length - 1; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                B[g] = A[i];
                g--;
            } else {
                B[j] = A[i];
                j++;
            }
        }
        return B;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4, 5, 6, 8})));
    }
}
