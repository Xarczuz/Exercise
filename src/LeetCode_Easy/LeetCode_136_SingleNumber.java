package LeetCode_Easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_136_SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

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

    public static void main(String[] args) {
        System.out.println(new LeetCode_136_SingleNumber().singleNumber(new int[]{2, 2, 1}));
    }
}
