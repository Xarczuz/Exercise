package Euler1to50;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Next Distinct primes factors Problem 47 The first two consecutive numbers to
 * have two distinct prime factors are:
 * 
 * 14 = 2 × 7 15 = 3 × 5
 * 
 * The first three consecutive numbers to have three distinct prime factors are:
 * 
 * 644 = 2² × 7 × 23 645 = 3 × 5 × 43 646 = 2 × 17 × 19.
 * 
 * Find the first four consecutive integers to have four distinct prime factors
 * each. What is the first of these numbers?
 * 
 * 
 * @author Chjun-chi
 * 
 */
public class DistinctPrimesFactors {
	private static ArrayList<Integer> primes = new ArrayList<>();
	public static void main(String[] args) {
		Timer t = new Timer();
		for (int i = 2; i < 1000; i++) {
			if (checkPrime(i)) {
				primes.add(i);
			}
		}
		int consecutive = 4;
		int distinctPrimes = consecutive;
		LinkedList<Integer> stack = new LinkedList<>();
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			if (distinctPrimes(i) == distinctPrimes) {
				if (stack.size() > 0 && (stack.getLast() + 1) == i) {
					stack.add(i);
				} else {
					stack.clear();
				}
				if (stack.size() == 0) {
					stack.add(i);
				}
				if (stack.size() == consecutive) {
					break;
				}
			}
		}

		for (Integer integer : stack) {
			System.out.println(integer);
		}
		t.time();
	}
	public static int distinctPrimes(int nr) {
		int nrOfDistinctPrimes = 0;
		for (Integer prime : primes) {
			if (nr % prime == 0) {
				nrOfDistinctPrimes++;
			}
		}
		return nrOfDistinctPrimes;
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
}
