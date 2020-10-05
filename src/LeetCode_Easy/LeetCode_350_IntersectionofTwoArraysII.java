package LeetCode_Easy;

import java.util.ArrayList;

public class LeetCode_350_IntersectionofTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {

        ArrayList<Integer> integers1 = new ArrayList<>(nums1.length);
        ArrayList<Integer> integers2 = new ArrayList<>(nums2.length);
        for (int k : nums1) {
            integers1.add(k);
        }

        for (int j : nums2) {
            if (findInt(integers1, j)) {
                integers2.add(j);
            }
        }

        int[] ints = new int[integers2.size()];
        int i = 0;
        for (int n : integers2) {
            ints[i++] = n;
        }

        return ints;
    }

    private boolean findInt(ArrayList<Integer> integers1, int j) {
        for (int i = 0; i < integers1.size(); i++) {
            if (integers1.get(i) == j) {
                integers1.remove(i);
                return true;
            }
        }
        return false;
    }

}
