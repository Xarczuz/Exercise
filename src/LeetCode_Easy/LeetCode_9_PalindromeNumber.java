package LeetCode_Easy;

public class LeetCode_9_PalindromeNumber {
    public boolean isPalindrome(int x) {
        long reverse = 0;
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        while (x > reverse) {
            int n = x % 10;
            x /= 10;
            reverse = reverse * 10 + n;
        }
        return reverse == x || x == reverse / 10;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_9_PalindromeNumber().isPalindrome(121));
    }
}
