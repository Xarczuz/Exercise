package LeetCode_Easy;

public class LeetCode_747_LargestNumberAtLeastTwiceofOthers {

    public static int dominantIndex(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = -1, prevMax = -1;
        int maxi = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                prevMax = max;
                max = nums[i];
                maxi = i;
            } else if (prevMax < nums[i]) {
                prevMax = nums[i];
            }
        }
        if (max / 2d >= prevMax) {
            return maxi;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{1}));
    }
}
