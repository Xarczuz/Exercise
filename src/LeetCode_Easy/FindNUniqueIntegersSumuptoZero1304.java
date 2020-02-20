package LeetCode_Easy;

import java.util.Arrays;

public class FindNUniqueIntegersSumuptoZero1304 {
    public static int[] sumZero(int n) {
        int[] zeroSum = new int[n];
        int nr = 1000;
        if (n % 2 != 0) {
            zeroSum[n - 1] = 0;
            n--;
        }
        for (int i = 0; i < n; i++) {
            zeroSum[i] = nr;
            i++;
            zeroSum[i] = nr * (-1);
            nr--;
        }
        return zeroSum;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(11)));
        System.out.println(Arrays.toString(sumZero(3)));
        System.out.println(Arrays.toString(sumZero(1)));
        System.out.println(Arrays.toString(sumZero(1001)));
    }
}
