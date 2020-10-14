package LeetCode_Easy;

public class LeetCode_1137_NthTribonacciNumber {

    public static int tribonacci(int n) {

        int a = 0, b = 1, c = 1;
        if (n == 0) {
            return a;
        } else if (n == 1) {
            return b;
        } else if (n == 2) {
            return c;
        }

        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = a + b + c;
            a = b;
            b = c;
            c = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
