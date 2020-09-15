package LeetCode_Easy;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_532_KdiffPairsinanArray {
    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4, 4}, 0));
    }

    static public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<String> pairs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i])) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                System.out.println(i + "-" + j);
                int value = nums[j] - nums[i];
                if (value == k) {
                    if (nums[i] == nums[j]) {
                        pairs.add(nums[i] + "-" + nums[j]);
                        pairs.add(nums[j] + "*" + nums[i]);
                    } else {
                        pairs.add(nums[i] + "-" + nums[j]);
                        pairs.add(nums[j] + "-" + nums[i]);
                    }
                } else if (value > k) {
                    break;
                }
            }
            hashSet.add(nums[i]);
        }
        return pairs.size() / 2;
    }

}
