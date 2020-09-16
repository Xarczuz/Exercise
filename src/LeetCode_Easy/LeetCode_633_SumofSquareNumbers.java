package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_633_SumofSquareNumbers {

    public boolean judgeSquareSum(int c) {

        HashSet<Integer> hashSet = new HashSet<>();
        int s = (int) Math.sqrt(c);
        for (int i = 0; i <= s; i++) {
            int sum = i * i;
            hashSet.add(sum);
            if (hashSet.contains(c - sum)) {
                return true;
            }
        }
        return false;
    }

}
