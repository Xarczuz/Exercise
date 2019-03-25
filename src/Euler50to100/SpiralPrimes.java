package Euler50to100;

import java.util.ArrayList;

/**
 * 
 * Problem 58
 * 
 * @author chjunchi
 *
 */
public class SpiralPrimes {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		ArrayList<Integer> prim = new ArrayList<>();
		arr.add(1);
		int n = 7;
		while (true) {
		int length = n * n;
		int idx = 0;
		int jump = 2;
		int nextJump = 0;
		for (int i = 1; i <= length; i++) {
			if (idx == jump) {
				arr.add(i);
				if (checkPrime(i)) {
					prim.add(i);
				}
				idx = 0;
				nextJump++;
			}
			if (nextJump == 4) {
				jump += 2;
				nextJump = 0;
			}
			idx++;
		}
		
		double ratio = (double)prim.size() / arr.size();
		if (ratio < 0.1f) {
			System.out.println("length n: " + n);
			return;
		}
		n+=2;
		}
	//	System.out.println(arr);

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
