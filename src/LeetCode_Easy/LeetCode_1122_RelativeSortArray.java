package LeetCode_Easy;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCode_1122_RelativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        int[] result = new int[arr1.length];
        HashSet<Integer> hashSet = new HashSet<>();
        int index = 0;
        for (int i : arr2) {
            hashSet.add(i);
            boolean beforeFound = true;
            for (int j : arr1) {
                if (i == j) {
                    result[index] = j;
                    index++;
                    beforeFound = false;
                } else if (!beforeFound) {
                    break;
                }
            }
        }
        for (int i : arr1) {
            if (!hashSet.contains(i)) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
