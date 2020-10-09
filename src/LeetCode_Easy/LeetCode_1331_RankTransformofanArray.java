package LeetCode_Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_1331_RankTransformofanArray {
    public int[] arrayRankTransform(int[] arr) {

        HashSet<Integer> hashSet = new HashSet<>(arr.length);
        for (int n : arr) {
            hashSet.add(n);
        }

        int[] sortedArr = new int[hashSet.size()];
        int k = 0;
        for (int n : hashSet) {
            sortedArr[k++] = n;
        }

        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> hashMap = new HashMap<>(sortedArr.length);
        for (int j = 0; j < sortedArr.length; j++) {
            hashMap.put(sortedArr[j], j + 1);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = hashMap.get(arr[i]);
        }
        return arr;
    }

    public static int[] arrayRankTransform2(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> hashMap = new HashMap<>(sortedArr.length);
        int r = 1;
        int prev = sortedArr[0];
        hashMap.put(prev, r++);
        for (int j = 1; j < sortedArr.length; j++) {
            if (sortedArr[j] != prev) {
                hashMap.put(sortedArr[j], r++);
            }
            prev = sortedArr[j];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = hashMap.get(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayRankTransform2(new int[]{3, 4, 2})));
    }
}
