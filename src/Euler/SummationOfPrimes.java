package Euler;

public class SummationOfPrimes {

	public static void main(String[] args) {
		long start2 = System.currentTimeMillis();
		System.out.println("Sum of all primes: " + sumOfAllPrimes(2000000));
		long end2 = System.currentTimeMillis();
		System.out.println((end2 - start2) + "ms");
	}

	public static long sumOfAllPrimes(int n) {
		long idx = 2;
		long sum = 0;
		while (idx <= n) {
			if (checkPrime(idx)) {
				sum += idx;
			}
			idx++;
		}
		return sum;
	}

	public static boolean checkPrime(long n) {

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

}
