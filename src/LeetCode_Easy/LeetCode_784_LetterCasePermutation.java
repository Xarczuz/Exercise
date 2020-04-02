package LeetCode_Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class LeetCode_784_LetterCasePermutation {

    public static void main(String[] args) {
        String S = "a1b2";
        System.out.println(letterCasePermutation(S));
        System.out.println("[dntj, dntJ, dnTj, dnTJ, dNtj, dNtJ, dNTj, dNTJ, Dntj, DntJ, DnTj, DnTJ, DNtj, DNtJ, DNTj, DNTJ]");
    }

    public static void letterCasePermutationRec(String S) {
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c <= 'z' && c > 'Z') {
                chars[i] = (char) (c - 32);
            } else if (c < 'A') {
                chars[i] = c;
            } else {
                chars[i] = (char) (c + 32);
            }
            if (hashSet.add(String.valueOf(chars))) {
                letterCasePermutationRec(new String(chars));
            } else if (c > 'A') {
                return;
            }
        }
    }

    static HashSet<String> hashSet = new HashSet<>();

    public static List<String> letterCasePermutation(String S) {
        letterCasePermutationRec(S);
        List<String> ss = new ArrayList<>(hashSet);
        ss.sort(String::compareTo);
        Collections.reverse(ss);
        return ss;
    }
}
