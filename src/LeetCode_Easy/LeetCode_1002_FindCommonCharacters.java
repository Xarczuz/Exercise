package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1002_FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        int[][] arr = new int[26][A.length]; //97 - 122

        for (int i = 0; i < A.length; i++) {
            char[] chars = A[i].toCharArray();
            for (int j = 0; j < A[i].length(); j++) {
                arr[chars[j] - 97][i]++;
            }
        }

        List<String> list = new ArrayList<>();

        char current = 0;
        while (current < 26) {
            int checker = arr[current][0];
            if (checker == 0) {
                current++;
                continue;
            }
            int min = Math.min(Integer.MAX_VALUE, checker);
            for (int i = 1; i < A.length; i++) {
                if (arr[current][i] != 0) {
                    min = Math.min(min, arr[current][i]);
                } else {
                    min = 0;
                    break;
                }
            }
            for (int i = 0; i < min; i++) {
                list.add(String.valueOf((char) (current + 97)));
            }
            current++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_1002_FindCommonCharacters().commonChars(new String[]{"bella", "label", "roller"}));
        System.out.println(new LeetCode_1002_FindCommonCharacters().commonChars(new String[]{"cool", "lock", "cook"}));
        System.out.println(new LeetCode_1002_FindCommonCharacters().commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
    }
}
