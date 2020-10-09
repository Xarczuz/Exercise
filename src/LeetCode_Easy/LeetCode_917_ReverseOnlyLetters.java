package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_917_ReverseOnlyLetters {

    public static String reverseOnlyLetters(String S) {
        StringBuilder st = new StringBuilder();

        char[] chars = S.toCharArray();
        int j = 0;
        HashMap<Integer, Character> map = new HashMap<>();
        while (j < chars.length) {
            if (chars[j] >= '!' && chars[j] < 'A' || chars[j] > 'Z' && chars[j] < 'a') {
                map.put(j, chars[j]);
            }
            j++;
        }
        int n = 0;
        for (int k = chars.length - 1; k >= 0; k--) {
            if (map.containsKey(n)) {
                st.append(map.get(n));
                n++;
                k++;
                continue;
            }
            if (chars[k] <= 'Z' && chars[k] >= 'A' || chars[k] <= 'z' && chars[k] >= 'a') {
                st.append(chars[k]);
                n++;
            }
        }
        while (n < chars.length) {
            if (map.containsKey(n)) {
                st.append(map.get(n));
                n++;
            }
        }
        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("z<*zj"));
        System.out.println(reverseOnlyLetters("mv']4"));
    }
}
