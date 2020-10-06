package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_409_LongestPalindrome {

    public static int longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int[] characters = new int[58];

        for (int i = 0; i < chars.length; i++) {
            characters[chars[i] - 'A']++;
        }

        System.out.println(Arrays.toString(characters));

        boolean odd = false;
        int tot = 0;
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] % 2 == 0) {
                tot += characters[i];
            } else if ((characters[i] - 1) % 2 == 0) {
                tot += characters[i] - 1;
            }
            if (characters[i] % 2 != 0) {
                odd = true;
            }
        }

        if (odd) {
            tot++;
        }
        return tot;
    }

    private static boolean isPalindrome(char[] s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s[i] != s[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccccdddd"));
    }
}
