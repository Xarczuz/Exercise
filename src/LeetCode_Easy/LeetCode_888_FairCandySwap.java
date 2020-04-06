package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_888_FairCandySwap {

    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        Arrays.sort(A);
        Arrays.sort(B);
        int sumA = 0;
        int sumB = 0;
        for (int j = 0; j < A.length; j++) {
            sumA += A[j];
        }
        for (int k = 0; k < B.length; k++) {
            sumB += B[k];
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int a = A[i];
            for (int i1 = B.length - 1; i1 >= 0; i1--) {
                int b = B[i1];
                if (sumA - a + b == sumB - b + a) {
                    res[0] = a;
                    res[1] = b;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(1 ^ 2);
        System.out.println();

    }
}
