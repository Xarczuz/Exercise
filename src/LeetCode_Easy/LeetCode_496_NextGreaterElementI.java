package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int j = 0; j < nums2.length; j++) {
            hashMap.put(nums2[j], j + 1);
        }
        for (int i = 0; i < nums1.length; i++) {
            boolean notFound = true;
            int next = hashMap.getOrDefault(nums1[i], -1);
            if (next == -1) {
                res[i] = -1;
                continue;
            }
            for (int j = next; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    notFound = false;
                    break;
                }
            }
            if (notFound) {
                res[i] = -1;
            }
        }

        return res;
    }
}
