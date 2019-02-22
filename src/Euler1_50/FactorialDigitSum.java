package Euler1_50;

import java.math.BigInteger;

public class FactorialDigitSum {

	public static void main(String[] args) {
		BigInteger bigSum = factorial(100);
		String bigNr = bigSum.toString();
		long sum = 0;
		for (int i = 0; i < bigNr.length(); i++) {
			sum += Integer.parseInt(bigNr.substring(i, i+1));
		}
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
