package LeetCode_Easy;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_169_MajorityElement {

    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        for (int i : nums) {
            integerIntegerHashMap.put(i, integerIntegerHashMap.getOrDefault(i, 0) + 1);
        }
        int major = 0;
        int value = 0;
        for (Map.Entry<Integer, Integer> s : integerIntegerHashMap.entrySet()) {
            if (s.getValue() > value) {
                major = s.getKey();
                value = s.getValue();
            }
        }
        return major;
    }

    public int majorityElement3(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
