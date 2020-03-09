package LeetCode_Easy;

import java.util.HashMap;
import java.util.HashSet;

public class LeetCode_1207_UniqueNumberofOccurrences {
    public static boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 1) + 1);
        }
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : hashMap.values()) {
            if (!hashSet.add(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(uniqueOccurrences(new int[]{1, 2}));
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));

    }
}
