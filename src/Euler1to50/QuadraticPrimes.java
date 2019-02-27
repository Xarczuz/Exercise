package Euler1to50;

/**
 * @author Chjun-chi
 *
 *         Euler discovered the remarkable quadratic formula:
 * 
 *         n2+n+41 It turns out that the formula will produce 40 primes for the
 *         consecutive integer values 0≤n≤39. However, when
 *         n=40,402+40+41=40(40+1)+41 is divisible by 41, and certainly when
 *         n=41,412+41+41 is clearly divisible by 41.
 * 
 *         The incredible formula n2−79n+1601 was discovered, which produces 80
 *         primes for the consecutive values 0≤n≤79. The product of the
 *         coefficients, −79 and 1601, is −126479.
 * 
 *         Considering quadratics of the form:
 * 
 *         n2+an+b, where |a|<1000 and |b|≤1000
 * 
 *         where |n| is the modulus/absolute value of n e.g. |11|=11 and |−4|=4
 *         Find the product of the coefficients, a and b, for the quadratic
 *         expression that produces the maximum number of primes for consecutive
 *         values of n, starting with n=0.
 */
public class QuadraticPrimes {
	public static void main(String[] args) {
		
		int maxN = 0;
		int maxA = 0;
		int maxB = 0;
		for (int a = 999; -1000 <= a; a--) {
			for (int b = 1000; -1000 <= b; b--) {

				int n = 0;
				long i = 1;
				while (true) {
					long sum = Math.abs((i * i) + (a * i)+  b);
					
					if (checkPrime(sum)) {
						n++;
						if (n > maxN) {
							maxN = n;
							maxA = a;
							maxB = b;
						}
					} else {
						break;
					}
					i++;
				}
				n=0;
			}
		}
		System.out.printf("Max n:%10d A:%10d B:%10d\n",maxN,maxA,maxB);
		System.out.println("Product:"+(maxA*maxB));

	}
	public static void formula2() {
		int n = 0;
		for (int i = 0; i < 1000; i++) {
			int sum = (i * i) - (999 * i) + 61;
			if (checkPrime(sum)) {
				n++;
				System.out.println(n);
			}
		}

	}
	
	public static boolean checkPrimeBruteForce(long n){
		for (int i = 2; i < n; i++ ) {
			if (n % i == 0)
				return false;
		}
		return true;
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
