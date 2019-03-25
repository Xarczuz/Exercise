package Euler50to100;

import java.math.BigInteger;

/**
 * Powerful digit sum
 * 
 * Problem 56 A googol (10100) is a massive number: one followed by one-hundred
 * zeros; 100100 is almost unimaginably large: one followed by two-hundred
 * zeros. Despite their size, the sum of the digits in each number is only 1.
 * 
 * Considering natural numbers of the form, ab, where a, b < 100, what is the
 * maximum digital sum?
 * 
 * @author chjunchi
 *
 */
public class PowerfulDigitSum {

	public static void main(String[] args) {
		long max=0;
		for (int a = 1; a < 100; a++) {
			for (int b = 1; b < 100; b++) {
				BigInteger nr = new BigInteger(String.valueOf(a));
				nr = nr.pow(b);
				long tmp = digitSum(nr.toString());
				if(max<tmp) {
					max = tmp;
				}
			}
		}
		System.out.println("Max digit sum: "+max);
	}
	public static long digitSum(String nr) {
		long dSum=0;
		for (int i = 0,size=nr.length(); i < size; i++) {
			dSum += Integer.parseInt(nr.substring(i,i+1));
		}
		return dSum;
	}
}
