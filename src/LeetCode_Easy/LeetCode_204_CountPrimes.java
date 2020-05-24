package LeetCode_Easy;

public class LeetCode_204_CountPrimes {

    public int countPrimes(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += checkPrime(i) ? 1 : 0;
        }
        return count;
    }

    private boolean checkPrime(long n) {
        if (n == 2 || n == 3)
            return true;
        if ((n & 1) == 0 || n % 3 == 0)
            return false;
        int limit = (int) (Math.sqrt(n) + 1);
        for (int i = 5, w = 2; i < limit; i += w, w = 6 - w) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes2(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }
}
