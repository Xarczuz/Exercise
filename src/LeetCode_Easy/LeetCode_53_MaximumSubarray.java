package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_53_MaximumSubarray {

    public static void main(String[] args) {
        LeetCode_53_MaximumSubarray obj = new LeetCode_53_MaximumSubarray();
        // TODO OPTIMIZE
        System.out.println(obj.maxSubArray(new int[]{1, 2, -1}));//3
        System.out.println(obj.maxSubArray(new int[]{1, 2}));//3
        System.out.println(obj.maxSubArray(new int[]{-2, -1}));//-1
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));//6
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -41, 2, 1, -5, 4}));//4
        System.out.println(obj.maxSubArray(new int[]{8, -19, 5, -4, 20}));//21
        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, 6, -1, 2, 1, -5, 44}));//51
        System.out.println(obj.maxSubArray(new int[]{1, 2, 3, 4, 5, -90, 4, 1, 5, 4, 88}));//102
    }

    private int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        List<Integer> list = new ArrayList<>();
        int maxSum = Integer.MIN_VALUE;
        boolean positiveArr = true;
        int positiveSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxSum) {
                maxSum = nums[i];
            }
            if (nums[i] < 0 && i != 0) {
                list.add(i);
            }
            if (nums[i] >= 0) {
                positiveSum += nums[i];
            } else {
                positiveArr = false;
            }
        }
        if (positiveArr) {
            return positiveSum;
        }
        list.add(-1);
        list.add(nums.length);

        int count = 0;
        for (int p : list) {
            for (int q : list) {
                if (p >= q) {
                    continue;
                }
                count++;
                int sum = 0;
                for (int i = p + 1; i < q; i++) {
                    sum += nums[i];
                }
                if (sum > maxSum && sum != 0) {
                    maxSum = sum;
                }
            }
        }
        System.out.println("itereringar: " + count);
        return maxSum;
    }
}
