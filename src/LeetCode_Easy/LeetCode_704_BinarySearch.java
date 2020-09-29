package LeetCode_Easy;

public class LeetCode_704_BinarySearch {

    public int search(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public int search2(int[] nums, int target) {

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[j] == target) {
                return j;
            }
        }

        return -1;
    }

    public int search3(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int high = nums.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                return mid;
        }

        return -1;
    }
}
