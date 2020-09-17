package LeetCode_Easy;

public class LeetCode_496_NextGreaterElementI {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            boolean notFound = true;
            int next = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    next = j;
                }
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
