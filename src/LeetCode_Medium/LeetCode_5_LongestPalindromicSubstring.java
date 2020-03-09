package LeetCode_Medium;

public class LeetCode_5_LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int chunkSize = s.length();

        while (chunkSize > 0) {
            for (int i = 0; i < s.length(); i++) {
                if (i + chunkSize > s.length()) {
                    break;
                }
                String isItPalin = s.substring(i, i + chunkSize);
                if (checkPalindrome(isItPalin)) {
                    return isItPalin;
                }
            }
            chunkSize--;
        }
        return "";
    }

    public boolean checkPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < s.length() / 2; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome2(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int chunkSize = chars.length;
        while (chunkSize > 0) {
            for (int i = 0; i + chunkSize <= chars.length; i++) {
                if (checkPalindrome(chars, i, i + chunkSize - 1)) {
                    return s.substring(i, i + chunkSize);
                }
            }
            chunkSize--;
        }
        return "";
    }

    private boolean checkPalindrome(char[] chars, int i, int j) {
        for (; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new LongestPalindromicSubstring5().checkPalindrome("s"));

        // cbbd dbbc    babad dabab
        System.out.println(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome2("cbbd") + "-" + "bb");
        System.out.println(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome2("babad") + "-" + "bab");
        System.out.println(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome2("ss"));
        System.out.println(new LeetCode_5_LongestPalindromicSubstring().longestPalindrome2("awerhervragyhaeragdftmsr") + "-" + "rvr");
    }
}
