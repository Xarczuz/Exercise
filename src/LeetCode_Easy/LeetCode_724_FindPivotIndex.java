package LeetCode_Easy;

public class LeetCode_724_FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int left = 0, right = 0;
        for (int num : nums) {
            right += num;
        }
        for (int i = 0, length = nums.length; i < length; i++) {
            int nr = nums[i];
            right -= nr;
            if (left == right) {
                return i;
            }
            left += nr;
        }
        return -1;
    }
}
