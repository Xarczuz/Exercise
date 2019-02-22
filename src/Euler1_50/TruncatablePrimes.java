package Euler1_50;

/**
 * Truncatable primes Problem 37 The number 3797 has an interesting property.
 * Being prime itself, it is possible to continuously remove digits from left to
 * right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can
 * work from right to left: 3797, 379, 37, and 3.
 * 
 * Find the sum of the only eleven primes that are both truncatable from left to
 * right and right to left.
 * 
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 * 
 * 
 * 
 * 
 * @author Chjun-chi
 *
 */
public class TruncatablePrimes {

	public static void main(String[] args) {

		int truncs = 1;
		long idx = 8;
		long sum = 0;
		while (truncs <= 11) {
			if (checkPrime(idx)) {
				if (truncatable(String.valueOf(idx))) {
					truncs++;
					sum += idx;
					System.out.println(idx);
				}
			}
			idx++;
		}

		System.out.println("Trunc sum: " + sum);

	}

	public static boolean truncatable(String prime) {

		for (int i = 0; i < prime.length(); i++) {

			if (!checkPrime(
					Long.parseLong(prime.substring(i, prime.length())))) {
				return false;
			}
		}
		for (int i = prime.length(); 0 < i; i--) {
			if (!checkPrime(Long.parseLong(prime.substring(0, i)))) {
				return false;
			}
		}
		return true;
	}
	public static boolean checkPrime(long n) {
		if (n == 1) {
			return false;
		}
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
