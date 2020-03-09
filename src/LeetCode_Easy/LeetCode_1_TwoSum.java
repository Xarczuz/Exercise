package LeetCode_Easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numIndexMap.containsKey(nums[i])) {
                return new int[]{numIndexMap.get(nums[i]), i};
            }
            numIndexMap.put(diff, i);
        }
        return null;
    }
}
