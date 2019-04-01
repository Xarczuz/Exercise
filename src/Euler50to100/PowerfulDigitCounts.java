package Euler50to100;

import java.math.BigInteger;

import Euler1to50.Timer;

/**
 * Problem 63
 * 
 * @author Chjun-chi
 *
 */
public class PowerfulDigitCounts {

	public static void main(String[] args) {
		Timer t = new Timer();
		int diff = 0;
		int power = 100;
		int nr = 1;
		int counter = 0;
		while (diff < 2) {
			BigInteger number = new BigInteger("1");
			for (int j = 1; j <= power; j++) {
				number = number.multiply(new BigInteger(String.valueOf(nr)));
				if (number.toString().length() == j) {
						counter++;
						System.out.println(nr+"^"+j+ "+" +"nr: "+number.toString() + " counter: " + counter );
				} else {
					diff = number.toString().length() - j;
					break;
				}
			}
			nr++;
		}
		System.out.println("counter: " + counter);
		t.time();
	}

}
