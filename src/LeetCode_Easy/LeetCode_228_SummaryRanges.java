package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_228_SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        ArrayList<String> arr = new ArrayList<>();
        if (nums.length == 0) {
            return arr;
        }
        int prev = nums[0];
        if (nums.length == 1) {
            arr.add(String.valueOf(prev));
            return arr;
        }
        int startInterval = 0;
        for (int i = 1; i < nums.length; i++) {
            if (prev + 1 == nums[i]) {
                if (i == nums.length - 1) {
                    arr.add(getString(nums, nums[startInterval], i));
                }
            } else {
                if (startInterval == i - 1) {
                    arr.add(String.valueOf(prev));
                } else {
                    arr.add(getString(nums, nums[startInterval], i - 1));
                }
                if (i == nums.length - 1) {
                    arr.add(String.valueOf(nums[i]));
                }
                startInterval = i;
            }
            prev = nums[i];
        }
        return arr;
    }

    private static String getString(int[] nums, int num, int i2) {
        StringBuilder st = new StringBuilder();
        st.append(num).append("->").append(nums[i2]);
        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0}));
        System.out.println(summaryRanges(new int[]{}));
        System.out.println(summaryRanges(new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(summaryRanges(new int[]{-10, -9, -3}));
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{1, 3}));
    }
}
