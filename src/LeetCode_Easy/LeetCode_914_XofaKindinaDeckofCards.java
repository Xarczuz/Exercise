package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_914_XofaKindinaDeckofCards {

    static public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : deck) {
            hashMap.put(value, hashMap.getOrDefault(value, 0) + 1);
        }
        for (int i = 2; i <= 9; i++) {
            int checkedValues = 0;
            for (int value : hashMap.values()) {
                if (value % i != 0) {
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

    public static void main(String[] args) {

        hasGroupsSizeX(new int[]{1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2});
        hasGroupsSizeX(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2});
    }
}
