package LeetCode_Easy;

public class LeetCode_35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length <= 0) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[i] > target) {
                {
                    return i;
                }
            }
        }

        return nums.length;
    }
}
