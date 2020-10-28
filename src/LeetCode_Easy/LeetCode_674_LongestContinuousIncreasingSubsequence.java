package LeetCode_Easy;


public class LeetCode_674_LongestContinuousIncreasingSubsequence {

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int res = 0;
        int maxLength = 1;
        int prev = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (prev < nums[j]) {
                maxLength++;
            } else {
                res = Math.max(maxLength, res);
                maxLength = 1;
            }
            prev = nums[j];
        }
        return Math.max(maxLength, res);
    }

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{1,3,5,7}));
    }
}
