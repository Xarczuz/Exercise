package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_561_ArrayPartition_I {
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1, 4, 3, 2}));
    }
}
