package LeetCode_Easy;

import java.math.BigInteger;

public class LeetCode_172_FactorialTrailingZeroes {
    public static int trailingZeroes2(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }

    public static int trailingZeroes(int n) {
        if (n == 1 || n == 0)
            return 0;
        int zeros = 0;
        String number = factorial(n).toString();
        System.out.println(number);
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) - '0' == 0) {
                zeros++;
            } else {
                break;
            }
        }
        return zeros;
    }

    public static BigInteger recfact(long start, long n) {
        long i;
        if (n <= 16) {
            BigInteger r = new BigInteger(String.valueOf(start));
            for (i = start + 1; i < start + n; i++) {
                r = r.multiply(new BigInteger(String.valueOf(i)));
            }
            return r;
        }
        i = n / 2;
        return recfact(start, i).multiply(recfact(start + i, n - i));
    }

    public static BigInteger factorial(long n) {
        return recfact(1, n);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(7000));
    }
}
