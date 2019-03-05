package Euler50to100;

import java.util.ArrayList;
import java.util.HashSet;

import Euler1to50.Timer;

/**
 * 
 * 
 * Problem 51 By replacing the 1st digit of the 2-digit number *3, it turns out
 * that six of the nine possible values: 13, 23, 43, 53, 73, and 83, are all
 * prime.
 * 
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this
 * 5-digit number is the first example having seven primes among the ten
 * generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663,
 * 56773, and 56993. Consequently 56003, being the first member of this family,
 * is the smallest prime with this property.
 * 
 * Find the smallest prime which, by replacing part of the number (not
 * necessarily adjacent digits) with the same digit, is part of an eight prime
 * value family.
 * 
 * 
 * @author chjunchi
 *
 */
public class PrimeDigitReplacements {

	public static void main(String[] args) {
		Timer t = new Timer();
		final int PrimeValueFamily = 8;
		HashSet<String> primes = new HashSet<>();
		ArrayList<Integer> primeList = new ArrayList<>();
		for (int i = 2; i < 1000000; i++) {
			if (checkPrime(i)) {
				primes.add(String.valueOf(i));
				primeList.add(i);
			}
		}

		for (Integer p : primeList) {
			String s = String.valueOf(p);
			ArrayList<String> primeArray = toArray(s);
			ArrayList<String> primeFamily = new ArrayList<>();

			for (int i = 0; i < primeArray.size(); i++) {
				int j = 0;
				if (i == 0) {
					j = 1;
				}
				for (; j < 10; j++) {
					primeArray.set(i, String.valueOf(j));
					if (checkPrime(
							Integer.parseInt(arrayToString(primeArray)))) {
						primeFamily.add(arrayToString(primeArray));
					}
				}
				if (primeFamily.size() == PrimeValueFamily) {
					System.out.println(primeFamily.toString());
					return;
				} else {
					primeFamily = new ArrayList<>();
					primeArray = toArray(s);
					for (int k = 1; k < primeArray.size(); k++) {
						if (k == i) {
							continue;
						}
						int g = 0;
						if (i == 0) {
							g = 1;
						}
						for (; g < 10; g++) {
							primeArray.set(i, String.valueOf(g));
							primeArray.set(k, String.valueOf(g));
							if (checkPrime(Integer
									.parseInt(arrayToString(primeArray)))) {
								primeFamily.add(arrayToString(primeArray));
							}
						}
						if (primeFamily.size() == PrimeValueFamily) {
							System.out.println(primeFamily.toString());
							return;
						} else {
							primeFamily = new ArrayList<>();
							primeArray = toArray(s);

							for (int m = 1; m < primeArray.size(); m++) {
								if (k == m || i == m) {
									continue;
								}
								int l = 0;
								if (i == 0) {
									l = 1;
								}
								for (; l < 10; l++) {
									primeArray.set(i, String.valueOf(l));
									primeArray.set(k, String.valueOf(l));
									primeArray.set(m, String.valueOf(l));
									if (checkPrime(Integer.parseInt(
											arrayToString(primeArray)))) {
										primeFamily
												.add(arrayToString(primeArray));
									}
								}
								if (primeFamily.size() == PrimeValueFamily) {
									System.out.println(primeFamily.toString());
									t.time();
									return;
								} else {
									primeFamily = new ArrayList<>();
									primeArray = toArray(s);
								}
							}

						}
						if (primeFamily.size() == PrimeValueFamily) {
							System.out.println(primeFamily.toString());
							return;
						}
						primeFamily = new ArrayList<>();
						primeArray = toArray(s);
					}
				}
			}
		}
	}
	public static String arrayToString(ArrayList<String> arr) {
		String s = "";
		for (String string : arr) {
			s += string;
		}
		return s;
	}
	public static ArrayList<String> toArray(String s) {

		ArrayList<String> array = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			String tmp = s.substring(i, i + 1);
			array.add(tmp);
		}

		return array;

	}
	public static boolean checkPrime(long n) {
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
}
