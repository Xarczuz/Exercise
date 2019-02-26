package Euler1_50;

/**
 * Goldbach's other conjecture Problem 46 It was proposed by Christian Goldbach
 * that every odd composite number can be written as the sum of a prime and
 * twice a square.
 * 
 * 9 = 7 + 2×12 15 = 7 + 2×22 21 = 3 + 2×32 25 = 7 + 2×32 27 = 19 + 2×22 33 = 31
 * + 2×12
 * 
 * It turns out that the conjecture was false.
 * 
 * What is the smallest odd composite that cannot be written as the sum of a
 * prime and twice a square?
 * 
 * 
 * @author chjunchi
 *
 */
public class GoldbachsOtherConjecture {

	public static void main(String[] args) {
		int stop = 10000;
		for (int i = 9; i < stop; i = i + 2) {
			if (checkComp(i) && !checkPrime(i)) {
				boolean found = false;
				int prime = 0;
				for (int j = i - 1; 3 < j; j--) {
					if (checkPrime(j)) {
						prime = j;
						int square = i - prime;
						if (square % 2 == 0) {
							int sum = square / 2;
							double sq = Math.sqrt(sum);
							if (sq % 1 == 0) {
								System.out.println(i + " = " + prime + " + 2 x "
										+ sq + "^2");
								found = true;
								break;
							}
						}
					}
				}
				if (!found) {
					System.out.println("Smallest odd comp: " + i);
					return;
				}
			}

		}
	}

	public static boolean checkComp(long n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				return true;
			}
		}
		return false;
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
