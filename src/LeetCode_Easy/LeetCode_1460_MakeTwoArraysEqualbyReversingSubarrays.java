package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_1460_MakeTwoArraysEqualbyReversingSubarrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        for (int i = 0; i < target.length; i++) {
            if (target[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
}
