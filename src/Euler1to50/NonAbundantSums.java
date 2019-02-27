package Euler1to50;

import java.util.ArrayList;

/**
 * @author Chjun-chi
 * 
 *         A perfect number is a number for which the sum of its proper divisors
 *         is exactly equal to the number. For example, the sum of the proper
 *         divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28
 *         is a perfect number.
 * 
 *         A number n is called deficient if the sum of its proper divisors is
 *         less than n and it is called abundant if this sum exceeds n.
 * 
 *         As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the
 *         smallest number that can be written as the sum of two abundant
 *         numbers is 24. By mathematical analysis, it can be shown that all
 *         integers greater than 28123 can be written as the sum of two abundant
 *         numbers. However, this upper limit cannot be reduced any further by
 *         analysis even though it is known that the greatest number that cannot
 *         be expressed as the sum of two abundant numbers is less than this
 *         limit.
 * 
 *         Find the sum of all the >>>>>positive integers<<<<<<< which cannot be written as
 *         >>>>>>the sum of two abundant numbers<<<<<<<<<.
 */
public class NonAbundantSums {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int limit = 28123;
		ArrayList<Integer> arr = new ArrayList<Integer>();

		for (int i = 12; i <= 28123; i++) {
			int sum = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					sum += j;
				}
			}
			if (sum > i) {
				arr.add(i);
			}
		}

		int[] gr = new int[limit + 1];
		for (int j = 0; j < arr.size(); j++) {
			for (int j2 = 0; j2 < arr.size(); j2++) {
				if ((arr.get(j) + arr.get(j2) <= limit)) {
					gr[arr.get(j) + arr.get(j2)] = 1;
				}
			}
		}
		long sum = 0;
		for (int i = 1; i <= limit; i++) {
			if (gr[i] != 1) {
				sum += i;
			}
		}

		System.out.println(sum);
	}

}
