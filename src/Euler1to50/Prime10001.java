package Euler1to50;

public class Prime10001 {

	public static void main(String[] args) {
		long start2 = System.currentTimeMillis();
		findPrime(10001);

		long end2 = System.currentTimeMillis();
		System.out.println((end2 - start2) + "ms");

	}

	public static void findPrime(int n) {
		int idx = 2;
		int primesFound = 0;
		while (true) {
			if (checkPrime(idx)) {
				primesFound++;
				if (primesFound == n) {
					System.out.println("Prime:" + idx + " Prime nr:" + primesFound);
					return;
				}
			}
			idx++;
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
