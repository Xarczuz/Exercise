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
        int startIndex = 0;
        for (int i = 1; i < nums.length; i++) {

            if (prev + 1 == nums[i]) {
                if (i == nums.length - 1) {
                    StringBuilder st = new StringBuilder();
                    st.append(nums[startIndex]).append("->").append(nums[i]);
                    arr.add(st.toString());
                }
                prev = nums[i];
            } else if (prev + 1 != nums[i]) {
                if (startIndex == i - 1) {
                    arr.add(String.valueOf(prev));
                } else {
                    StringBuilder st = new StringBuilder();
                    st.append(nums[startIndex]).append("->").append(nums[i - 1]);
                    arr.add(st.toString());
                }
                startIndex = i;
                if (i == nums.length - 1) {
                    arr.add(String.valueOf(nums[i]));
                }
                prev = nums[i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
//        System.out.println(summaryRanges(new int[] {0}));
//        System.out.println(summaryRanges(new int[] {}));

//        System.out.println(summaryRanges(new int[]{0, 1, 2, 3, 4, 5}));
        System.out.println(summaryRanges(new int[]{-10, -9, -3}));
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{1, 3}));
    }
}
