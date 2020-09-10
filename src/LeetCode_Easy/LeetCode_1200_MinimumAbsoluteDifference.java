package LeetCode_Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_1200_MinimumAbsoluteDifference {
    static public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        Arrays.sort(arr);
        int absoluteDiff = Integer.MAX_VALUE;
        int start = arr[0];
        for (int i = 1; i < arr.length; i++) {
            absoluteDiff = Math.min(absoluteDiff, (arr[i] - start));
            start = arr[i];
        }
        start = arr[0];
        for (int value : arr) {
            if ((value - start) == absoluteDiff) {
                List<Integer> pair = new ArrayList<>();
                pair.add(start);
                pair.add(value);
                arrayLists.add(pair);
            }
            start = value;
        }
        System.out.println(arrayLists);
        return arrayLists;
    }

    public static void main(String[] args) {
        minimumAbsDifference(new int[]{4, 2, 1, 3});
        minimumAbsDifference(new int[]{1, 3, 6, 10, 15});
        minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27});

    }
}
