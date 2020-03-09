package LeetCode_Easy;

import java.util.Arrays;
import java.util.HashMap;

public class LeetCode_1365_HowManyNumbersAreSmallerThantheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        int i = 0;
        for (int n : nums) {
            int count = 0;
            for (int k : nums) {
                if (n > k) {
                    count++;
                }
            }
            arr[i] = count;
            i++;
        }
        return arr;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] arr = new int[nums.length];
        HashMap<Integer, Integer> memory = new HashMap<>();
        int i = 0;
        for (int n : nums) {
            int count = 0;
            if (memory.containsKey(n)) {
                count = memory.get(n);
            } else {
                for (int k : nums) {
                    if (n > k) {
                        count++;
                    }
                }
                memory.put(n, count);
            }
            arr[i] = count;
            i++;
        }
        return arr;
    }

    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int b[] = nums.clone();
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                continue;
            }
            map.put(nums[i], i);
        }
        for (int i = 0; i < b.length; i++) {
            nums[i] = map.get(b[i]);
        }
        return nums;
    }

}
