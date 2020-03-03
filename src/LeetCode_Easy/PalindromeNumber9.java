package LeetCode_Easy;

public class PalindromeNumber9 {
    public boolean isPalindrome(int x) {
        long reverse = 0;
        int original = x;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x > reverse) {
            int n = x % 10;
            x /= 10;
            reverse = reverse * 10 + n;
        }
        if ((reverse == x || x == reverse / 10) && original >= 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber9().isPalindrome(121));
    }
}
