package LeetCode_Easy;

public class LeetCode_643_MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        double maxSubArr = Integer.MIN_VALUE;
        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += nums[i + j];
            }
            maxSubArr = Math.max(maxSubArr, sum / (double) k);
        }

        return maxSubArr;
    }

    public static double findMaxAverage2(int[] nums, int k) {
        double maxSubArr = Integer.MIN_VALUE;
        int sum = 0;
        for (int j = 0; j < k; j++) {
            sum += nums[j];
        }
        maxSubArr = Math.max(maxSubArr, sum);
        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            maxSubArr = Math.max(maxSubArr, sum);
        }
        return maxSubArr / (double) k;
    }

    public static void main(String[] args) {
//        System.out.println(findMaxAverage2(new int[]{5}, 1));
        System.out.println(findMaxAverage2(new int[]{0, 1, 1, 3, 3}, 4));
//        System.out.println(findMaxAverage2(new int[]{0, 1, 1, 3, 3}, 1));
    }
}
