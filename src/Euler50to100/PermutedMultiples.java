package Euler50to100;

import java.util.HashSet;

import Euler1to50.Timer;

/**
 * Permuted multiples
 * 
 * Problem 52 It can be seen that the number, 125874, and its double, 251748,
 * contain exactly the same digits, but in a different order.
 * 
 * Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x,
 * contain the same digits.
 * 
 * 
 * @author chjunchi
 *
 */
public class PermutedMultiples {

	public static void main(String[] args) {
		Timer t = new Timer();
		for (int i = 123456; i < Integer.MAX_VALUE; i++) {
			boolean nextNr = false;
			HashSet<String> theNumber = new HashSet<>();
			String nr = String.valueOf(i);
			for (int j = 0; j < nr.length(); j++) {
				theNumber.add(nr.substring(j, j + 1));
			}
			for (int j = 2; j <= 6; j++) {
				if (nextNr)
					break;
				String mNr = String.valueOf(j * i);
				for (int k = 0; k < mNr.length(); k++) {
					if (!theNumber.contains(mNr.substring(k, k + 1))) {
						nextNr = true;
					}
				}
			}
			if (!nextNr) {
				System.out.println("The Nr: " + i);
				t.time();
				return;
			}
		}
	}
}
