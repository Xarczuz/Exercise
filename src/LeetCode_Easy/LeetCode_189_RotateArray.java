package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_189_RotateArray {

    public static void rotate(int[] nums, int k) {
        int moveXTimes = k % nums.length;
        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            int pos = (i + moveXTimes) % nums.length;
            nums[pos] = copy[i];
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        rotate(new int[]{1, 2, 3, 4, 5, 6}, 2);

    }
}









