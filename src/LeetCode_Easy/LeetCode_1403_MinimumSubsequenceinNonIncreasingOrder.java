package LeetCode_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1403_MinimumSubsequenceinNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        int sumArr = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if ((sumArr + nums[i]) > sum) {
                arr.add(nums[i]);
                return arr;
            } else {
                arr.add(nums[i]);
                sumArr += nums[i];
                sum -= nums[i];
                if (sumArr > sum) {
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_1403_MinimumSubsequenceinNonIncreasingOrder().minSubsequence(new int[]{4, 3, 10, 9, 8}));
        System.out.println(new LeetCode_1403_MinimumSubsequenceinNonIncreasingOrder().minSubsequence(new int[]{4, 4, 7, 6, 7}));
        System.out.println(new LeetCode_1403_MinimumSubsequenceinNonIncreasingOrder().minSubsequence(new int[]{5}));

    }
}
