package Euler1_50;

public class PrimeFactor {

	public static void main(String[] args) {
		long g = 600851475143L;
		long start = System.currentTimeMillis();
		largestPrimeFactor(g);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

	private static void largestPrimeFactor(long number) {
		for (long i = 2; i < number / 2; i++) {
			if (number % i == 0) {
				long f = number / i;
				boolean prime = checkPrime(f);
				System.out.println("Correct: " + f + " Prime:" + prime);
				if (prime) {
					break;
				}
			}
		}
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
