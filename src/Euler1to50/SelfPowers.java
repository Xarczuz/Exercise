package Euler1to50;

import java.math.BigInteger;

/**
 * Self powers Problem 48 The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * 
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 * 
 * 
 * 
 * @author Chjun-chi
 *
 */
public class SelfPowers {

	public static void main(String[] args) {
Timer t = new Timer();
		BigInteger sum = new BigInteger("0");
		for (int i = 1; i <= 1000; i++) {
			BigInteger nr = new BigInteger(String.valueOf(i));
			nr = nr.pow(i);
			sum = sum.add(nr);
		}
		String total = sum.toString();
		System.out.println(total.substring(total.length()-10));
		t.time();
	}

}
