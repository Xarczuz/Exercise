package LeetCode_Easy;

public class ReverseInteger7 {
    public static int reverse(int x) {
        long reverse = 0;
        while (x != 0) {
            int s = x % 10;
            x /= 10;
            reverse *= 10;
            if (reverse > Integer.MAX_VALUE) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE) {
                return 0;
            }
            reverse += s;
        }
        return (int) reverse;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-123));
    }
}
