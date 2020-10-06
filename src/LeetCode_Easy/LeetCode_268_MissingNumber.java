package LeetCode_Easy;

public class LeetCode_268_MissingNumber {

    public int missingNumber(int[] nums) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i <= nums.length; i++) {
            sum1 += i;
        }
        for (int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        return Math.abs(sum1 - sum2);
    }
}
