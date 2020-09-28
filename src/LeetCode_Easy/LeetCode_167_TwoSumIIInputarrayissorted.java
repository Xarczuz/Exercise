package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_167_TwoSumIIInputarrayissorted {

    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < numbers.length; i++) {
            int nr = numbers[i];
            int findNr = target - nr;
            for (int j = 0; j < numbers.length; j++) {
                if (numbers[j] == findNr && j != i) {
                    if (j > i) {
                        index2 = j;
                        index1 = i;
                    } else {
                        index2 = i;
                        index1 = j;
                    }
                } else if (numbers[j] > findNr) {
                    break;
                }
            }
            if (index1 != 0) {
                break;
            }
        }
        return new int[]{index1 + 1, index2 + 1};
    }

    public int[] twoSum2(int[] numbers, int target) {
        int index1 = 0;
        int index2 = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int nr = numbers[i];
            int findNr = target - nr;
            if (hashMap.containsKey(findNr)) {
                int j = hashMap.get(findNr);
                if (j != i) {
                    if (j > i) {
                        index2 = j;
                        index1 = i;
                    } else {
                        index2 = i;
                        index1 = j;
                    }
                    break;
                }
            }
            hashMap.put(nr, i);
        }
        return new int[]{index1 + 1, index2 + 1};
    }

    public int[] twoSum3(int[] numbers, int target) {
        int lo = 0, hi = numbers.length - 1;

        while (lo < hi) {
            int res = numbers[lo] + numbers[hi];

            if (res == target) return new int[]{lo + 1, hi + 1};
            if (res < target) lo++;
            else hi--;
        }
        return new int[]{-1, -1};
    }
}
