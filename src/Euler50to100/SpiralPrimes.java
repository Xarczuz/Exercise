package Euler50to100;

import Euler1to50.Timer;

/**
 * 
 * Problem 58
 * 
 * @author chjunchi
 *
 */
public class SpiralPrimes {
	public static void main(String[] args) {
		Timer t = new Timer();
		double arr=1;
		double prim=0;
		int n = 3;
		int jump = 2;
		int nextJump = 0;
		int start = 3;
		while (n < 100000) {
			int length = n * n;
			for (int i = start; i <= length; i += jump) {
				arr++;
				if (checkPrime(i)) {
					prim++;
				}
				nextJump++;
				if (nextJump == 4) {
					jump += 2;
					nextJump = 0;
				}
			}
			start = length;
			double ratio =  prim / arr;
			if (ratio < 0.1f) {
				System.out.println("length n: " + n);
				t.time();//~150ms
				return;
			}
			n += 2;
		}
	}
	public static boolean checkPrime(int n) {
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
