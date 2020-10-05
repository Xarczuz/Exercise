package LeetCode_Easy;

import java.util.HashSet;
import java.util.Iterator;

public class LeetCode_349_IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> integers1 = new HashSet<>();
        HashSet<Integer> integers2 = new HashSet<>();
        for (int i = 0, nums1Length = nums1.length; i < nums1Length; i++) {
            integers1.add(nums1[i]);
        }
        for (int i = 0, nums2Length = nums2.length; i < nums2Length; i++) {
            int j = nums2[i];
            if (integers1.contains(j)) {
                integers2.add(j);
            }
        }
        int[] ints = new int[integers2.size()];
        int i = 0;
        for (Iterator<Integer> iterator = integers2.iterator(); iterator.hasNext(); ) {
            int n = iterator.next();
            ints[i++] = n;
        }
        return ints;
    }
}
