package LeetCode_Easy;

import java.util.HashSet;

public class NRepeatedElementinSize2NArray961 {
    public static int repeatedNTimes(int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int value : A) {
            if (hashSet.contains(value)) {
                return value;
            } else {
                hashSet.add(value);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{5, 1, 5, 2, 5, 3, 5, 4}));
    }
}
