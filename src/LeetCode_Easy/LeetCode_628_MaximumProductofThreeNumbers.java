package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_628_MaximumProductofThreeNumbers {

    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3];
        int a = nums[nums.length - 1];
        nums[0] *= -1;
        nums[1] *= -1;
        if (nums[0] > 0 && nums[1] > 0) {
            max = Math.max(a * nums[0] * nums[1], max);
        }
        return max;
    }
}
