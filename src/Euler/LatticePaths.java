package Euler;

import java.math.BigInteger;

public class LatticePaths {

	public static void main(String[] args) {
		permu();
	}

	public static void permu() {
		int n = 20;
		int length = n * 2;
		BigInteger sum = factorial(length).divide((factorial(length - n).multiply(factorial(n))));
		System.out.println(sum);
	}

	public static BigInteger factorial(int n) {
		BigInteger sum = new BigInteger("1");
		for (long i = 1; i <= n; i++) {
			sum = sum.multiply(new BigInteger(i+""));
		}
		return sum;
	}
}
