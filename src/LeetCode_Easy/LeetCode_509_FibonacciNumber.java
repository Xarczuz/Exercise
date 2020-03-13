package LeetCode_Easy;

public class LeetCode_509_FibonacciNumber {

    public int fib(int N) {
        if (N == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 1; i < N; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_509_FibonacciNumber().fib(3));
    }
}
