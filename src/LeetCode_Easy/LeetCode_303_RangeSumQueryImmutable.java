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
        private int[] arr;

        public NumArray2(int[] nums) {
            if (nums.length == 0)
                return;

            arr = new int[nums.length];
            arr[0] = nums[0];
            for (int i = 1; i < nums.length; i++)
                arr[i] = nums[i] + arr[i - 1];
        }

        public int sumRange(int i, int j) {
            if (i == 0)
                return arr[j];
            return arr[j] - arr[i - 1];
        }
    }

}
