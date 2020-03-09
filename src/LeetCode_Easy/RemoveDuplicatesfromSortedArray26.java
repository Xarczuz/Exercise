package LeetCode_Easy;

import java.util.Arrays;

public class RemoveDuplicatesfromSortedArray26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int prev = nums[0];
        int indexToKeepTrack = 1;
        boolean found = true;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev && found) {
                indexToKeepTrack = i;
                found = false;
            }
            if (nums[i] != prev) {
                prev = nums[i];
                nums[indexToKeepTrack] = prev;
                indexToKeepTrack++;
                count++;
            }

        }
        System.out.println(Arrays.toString(nums));
        return count;
    }

    public static void main(String[] args) {
        new RemoveDuplicatesfromSortedArray26().removeDuplicates(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 2});

        new RemoveDuplicatesfromSortedArray26().removeDuplicates(new int[]{1, 20, 20, 20, 30, 30, 40, 50});
        new RemoveDuplicatesfromSortedArray26().removeDuplicates(new int[]{1, 2, 3, 4, 5});
        new RemoveDuplicatesfromSortedArray26().removeDuplicates(new int[]{1, 1, 2});
        new RemoveDuplicatesfromSortedArray26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
