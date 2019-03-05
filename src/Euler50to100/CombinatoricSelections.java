package Euler50to100;

import java.math.BigInteger;

/**
 * Combinatoric selections
 * 
 * Problem 53 There are exactly ten ways of selecting three from five, 12345:
 * 
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 * 
 * In combinatorics, we use the notation, 5C3 = 10.
 * 
 * In general,
 * 
 * nCr = n! /r!(n−r)! ,where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1. It is
 * not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 * 
 * How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are
 * greater than one-million?
 * 
 * 
 * @author chjunchi
 *
 */
public class CombinatoricSelections {

	public static void main(String[] args) {
		int total = 0;
		for (int n = 1; n <= 100; n++) {
			for (int r = 0; r <= n; r++) {
				if (combinatoric(n, r).compareTo(new BigInteger("1000000")) == 1) {
					System.out.println(n+" C "+r+" = "+combinatoric(n, r));
					total++;
				}
			}
		}

		System.out.println("Total: " + total);
	}
	public static BigInteger combinatoric(int n, int r) {
		return factorial(n).divide(factorial(r).multiply(factorial(n - r)));
	}
	public static BigInteger factorial(int n) {
		BigInteger sum = new BigInteger("1");
		for (long i = 1; i <= n; i++) {
			sum = sum.multiply(new BigInteger(i + ""));
		}
		return sum;
	}
}
