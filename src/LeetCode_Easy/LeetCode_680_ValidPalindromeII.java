package LeetCode_Easy;

public class LeetCode_680_ValidPalindromeII {

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        return isPalindrome1(chars) || isPalindrome2(chars);
    }

    private static boolean isPalindrome1(char[] s) {
        int odd = 0;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                if (odd == 1) {
                    return false;
                }
                j++;
                odd++;
            }
        }
        return true;
    }

    private static boolean isPalindrome2(char[] s) {
        int odd = 0;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            if (s[i] != s[j]) {
                if (odd == 1) {
                    return false;
                }
                i--;
                odd++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(validPalindrome("teest"));
//        System.out.println(validPalindrome("aabbccccd"));
        System.out.println(validPalindrome("eedede"));
    }
}
