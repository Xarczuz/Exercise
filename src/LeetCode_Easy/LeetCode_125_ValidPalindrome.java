package LeetCode_Easy;

public class LeetCode_125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(new LeetCode_125_ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new LeetCode_125_ValidPalindrome().isPalindrome("Aa"));
    }

    public boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c = s.charAt(i);
            if (!isAlphaNumeric(c)) {
                i++;
                continue;
            }
            char d = s.charAt(j);
            if (!isAlphaNumeric(d)) {
                j--;
                continue;
            }
            if (c >= 'A' && c <= 'Z') {
                c = (char) (c + 'a' - 'A');

            }
            if (d >= 'A' && d <= 'Z') {
                d = (char) (d + 'a' - 'A');
            }
            if (c != d) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

    public boolean isAlphaNumeric(Character c) {
        if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }

    public boolean isPalindrome2(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z' || c >= '0' && c <= '9') {
                sb.append(c);
            }
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) (c + 'a' - 'A'));
            }
        }
        String checkIfPalindrome = sb.toString();
        System.out.println(checkIfPalindrome);
        for (int i = 0, j = checkIfPalindrome.length() - 1; i < checkIfPalindrome.length() / 2; i++, j--) {
            if (checkIfPalindrome.charAt(i) != checkIfPalindrome.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
