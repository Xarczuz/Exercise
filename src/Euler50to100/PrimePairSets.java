package Euler50to100;

import java.util.HashSet;
import java.util.LinkedList;

import Euler1to50.Timer;

/**
 * problem 60
 * 
 * @author Chjun-chi
 *
 */
public class PrimePairSets {
	final static int iSize = 10000;
	static HashSet<Long> primes = new HashSet<>();
	public static void main(String[] args) {
		Timer t = new Timer();
		makePrimeList();
		start2();
		t.time();

	}
	public static void start2() {
		long maxSum = Integer.MAX_VALUE;
		for (Long prime : primes) {
			HashSet<Long> primePairSet = new HashSet<>();

			primePairSet.add(prime);
			for (Long prime2 : primes) {
				if (prime != prime2) {
					LinkedList<Long> temp = new LinkedList<>();
					for (Long l : primePairSet) {
						if (concatPrimePairs(prime2, l)) {
							temp.add(prime2);
						} else {
							temp.clear();
							break;
						}
					}
					for (Long long1 : temp) {
						primePairSet.add(long1);
					}
				}
			}
			if (primePairSet.size() == 5) {
				System.out.println(primePairSet);
				long sum = 0;
				for (Long long1 : primePairSet) {
					sum += long1;
				}
				if (maxSum > sum) {
					maxSum = sum;
					System.out.println("Min sum: " + maxSum);
					return;
				}
			}
		}


	}
	public static boolean concatPrimePairs(long p1, long p2) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append(p1);
		sb1.append(p2);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(p2);
		sb2.append(p1);
		if (checkPrime(Long.parseLong(sb1.toString()))
				&& checkPrime(Long.parseLong(sb2.toString()))) {
			return true;
		}
		return false;
	}

	public static HashSet<Long> makePrimeList() {
		for (long i = 2; i < iSize; i++) {
			if (checkPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
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
