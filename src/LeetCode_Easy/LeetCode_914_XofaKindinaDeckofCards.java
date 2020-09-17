package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_914_XofaKindinaDeckofCards {

    static public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : deck) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }

        for (int x = 2; x <= 9; x++) {
            int checkedValues = 0;
            for (int value : hashMap.values()) {
                if (value % x != 0) {
                    break;
                }
                checkedValues++;
            }
            if (checkedValues == hashMap.size()) {
                return true;
            }
        }
        return false;
    }

   static public int gcd(int divisor, int value) {
        if (value == 0) {
            return divisor;
        } else {
            return gcd(value, divisor % value);
        }
    }

    public static void main(String[] args) {
        System.out.println(gcd(0,14));
        System.out.println(gcd(14,28));


       // hasGroupsSizeX(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2});
      //  hasGroupsSizeX(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2});
    }
}
