package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_645_SetMismatch {
    public static int[] findErrorNums(int[] nums) {

        int dupe = 0;
        int missing = 0;

        int[] count = new int[nums.length + 1];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1, countLength = count.length; i < countLength; i++) {
            int nr = count[i];
            if (nr == 2) {
                dupe = i;
            } else if (nr == 0) {
                missing = i;
            } else if (missing != 0 && dupe != 0) {
                break;
            }
        }

        return new int[]{dupe, missing};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
    }
}
