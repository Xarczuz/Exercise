package LeetCode_Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LeetCode_136_SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> es : hashMap.entrySet()) {
            if (es.getValue() == 1) {
                return es.getKey();
            }
        }
        return 0;
    }

    public int singleNumber2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            boolean noDuplicate = true;
            int k = 0;
            for (; k < nums.length; k++) {
                if (i != k && nums[i] == nums[k]) {
                    noDuplicate = false;
                    break;
                }
            }
            if (noDuplicate) {
                return nums[i];
            }
        }

        return 0;
    }

    public int singleNumber3(int[] nums) {
        HashSet<Integer> s = new HashSet();
        for (int num : nums) {
            if (s.contains(num)) {
                s.remove(num);
            } else {
                s.add(num);
            }
        }
        int nr = 0;
        for (int i : s) {
            nr = i;
        }
        return nr;
    }

    public int singleNumber4(int[] nums) {
        int nr = 0;
        for (int num : nums) {
            nr ^= num;
        }
        return nr;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_136_SingleNumber().singleNumber(new int[]{2, 2, 1}));
    }
}
