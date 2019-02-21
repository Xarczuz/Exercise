package Euler;

public class HighlyDivisibleTriangularNumber {

	public static void main(String[] args) {
		long start2 = System.currentTimeMillis();
		System.out.println(HDTN(500));
		long end2 = System.currentTimeMillis();
		System.out.println((end2 - start2) + "ms");
	}

	public static long HDTN(long nr) {
		long idx = 1;
		long nthT = 0;
		while (divisorsBruteForce(nthT) < nr) {
			nthT += (idx);
			idx++;
		}
		return nthT;
	}

	private static long divisorsBruteForce(long n) {
		long d = 0;
		long limit = (int) Math.sqrt(n);
		for (long i = 1; i <= limit; i++) {
			if (n % i == 0) {
				d += 2;
			}
		}
		if (limit * limit == n) {
			d--;
		}
		return d;
	}

}
