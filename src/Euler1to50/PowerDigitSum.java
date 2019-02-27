package Euler1to50;

import java.math.BigInteger;

public class PowerDigitSum {

	public static void main(String[] args) {
		double p = Math.pow(2, 1000);
		System.out.println(p);
		BigInteger big = new BigInteger("1");
		for (int i = 0; i < 1000; i++) {
			big = big.multiply(new BigInteger("2"));
		}
		String s = big.toString();
		long sum = 0;
		System.out.println(s);
		for (int i = 0; i < s.length(); i++) {
			sum += Long.parseLong(s.substring(i, i + 1));
		}
		System.out.println(sum);
	}
}
