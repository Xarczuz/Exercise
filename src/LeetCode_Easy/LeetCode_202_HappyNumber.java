package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(new LeetCode_202_HappyNumber().isHappy(19));
    }

    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        while (n > 0) {
            int t = 0;
            int f = n;
            while (f > 0) {
                int r = f % 10;
                t += r * r;
                f /= 10;
            }
            if (t == 1) {
                return true;
            }
            if (hashSet.contains(t)) {
                return false;
            }
            n = t;
            hashSet.add(t);
        }
        return false;
    }

}
