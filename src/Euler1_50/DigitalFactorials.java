package Euler1_50;

import java.math.BigInteger;

/**
 * 
 * Digit factorials Problem 34 145 is a curious number, as 1! + 4! + 5! = 1 + 24
 * + 120 = 145.
 * 
 * Find the sum of all numbers which are equal to the sum of the factorial of
 * their digits.
 * 
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * 
 * 
 * @author Chjun-chi
 *
 */
public class DigitalFactorials {
	public static void main(String[] args) {
		Long total = 0L;
		for (int i = 3; i < 1000001; i++) {

			String f = i + "";
			BigInteger sum = new BigInteger("0");
			for (int j = 0; j < f.length(); j++) {
				sum = sum.add(factorial(Integer.parseInt(f.substring(j, j + 1))));

			}
			if (sum.toString().equals(f)) {
				total += i;
			}
		}
		System.out.println("Total: " + total);

	}

	public static BigInteger factorial(int n) {
		BigInteger sum = new BigInteger("1");
		for (long i = 1; i <= n; i++) {
			sum = sum.multiply(new BigInteger(i + ""));
		}
		return sum;
	}
}
