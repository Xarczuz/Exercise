package LeetCode_Easy;

public class LeetCode_303_RangeSumQueryImmutable {

    class NumArray {
        int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;

        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            return sum;
        }
    }

    class NumArray2 {
        int[] sums;

        public NumArray2(int[] nums) {
            sums = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                sums[i + 1] = sums[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

}
