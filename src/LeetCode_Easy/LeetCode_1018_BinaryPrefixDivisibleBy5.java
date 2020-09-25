package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1018_BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int num = 0;
        ArrayList<Boolean> booleans = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            num = (num * 2 + A[i]) % 5;
            booleans.add(num == 0);
        }
        return booleans;
    }

}
