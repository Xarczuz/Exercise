package Euler1to50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Prime permutations Problem 49 The arithmetic sequence, 1487, 4817, 8147, in
 * which each of the terms increases by 3330, is unusual in two ways: (i) each
 * of the three terms are prime, and, (ii) each of the 4-digit numbers are
 * permutations of one another.
 * 
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes,
 * exhibiting this property, but there is one other 4-digit increasing sequence.
 * 
 * What 12-digit number do you form by concatenating the three terms in this
 * sequence?
 * 
 * 
 * 
 * @author Chjun-chi
 *
 */
public class PrimePermutations {

	public static void main(String[] args) {
		int[] ignore = new int[]{1487, 4817, 8147};

		for (int i = 1001; i < 9999; i++) {

			for (int j = 0; j < ignore.length; j++) {
				if (ignore[j] == i) {
					continue;
				}
			}
			ArrayList<Integer> arr=permutaion(i);
			if (arr.size()==3) {
				if((Math.abs(arr.get(0)-arr.get(1))+ arr.get(1))==arr.get(2)) {	
					System.out.println("prime i = "+ arr);
				}				
				
			}

		}
	}

	static ArrayList<Integer> org;
	public static ArrayList<Integer> permutaion(int nr) {
		org = new ArrayList<>();
		
		HashSet<Integer> s = new HashSet<>();
		String tempNr = String.valueOf(nr);
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 0; i < tempNr.length(); i++) {
			org.add(Integer.parseInt(tempNr.substring(i,i+1)));
			s.add(Integer.parseInt(tempNr.substring(i,i+1)));
		}
		int count = 0;
		
		long permutaions = factorial(org.size());
		try {
			while (count < permutaions) {
				int N = org.size();
				int i = N - 1;
				while (org.get(i - 1) >= org.get(i)) {
					i = i - 1;
					
				}
				int j = N;
				while (org.get(j - 1) <= org.get(i - 1)) {
					j = j - 1;
					
				}
				// swap values at position i-1 and j-1
				swap(i - 1, j - 1);

				i++;
				j = N;
				while (i < j) {
					swap(i - 1, j - 1);
					i++;
					j--;
				}
				count++;
				String number = "";
				for (Integer integer : org) {
					number += integer;
				}
				if (checkPrime(Integer.parseInt(number))) {
				temp.add(Integer.parseInt(number));
				}
				// System.out.println(org);
			}			
		} catch (Exception e) {
			// Do nothing
		}

		return temp;
	}
	public static boolean checkPrime(int n) {
		if (n == 2 || n == 3)
			return true;
		if ((n & 1) == 0 || n % 3 == 0)
			return false;
		int limit = (int) (Math.sqrt(n) + 1);
		for (int i = 5, w = 2; i < limit; i += w, w = 6 - w) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	public static long factorial(int number) {
		long result = 1;

		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}

		return result;
	}

	public static BigInteger factorial(BigInteger number) {
		BigInteger result = BigInteger.valueOf(1);

		for (long factor = 2; factor <= number.longValue(); factor++) {
			result = result.multiply(BigInteger.valueOf(factor));
		}

		return result;
	}
	public static void swap(int i, int j) {
		int k = org.get(i);
		org.set(i, org.get(j));
		org.set(j, k);
	}

}
