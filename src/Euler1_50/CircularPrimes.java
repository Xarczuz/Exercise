package Euler1_50;

import java.util.HashSet;

/**
 * 
 * Circular primes Problem 35 The number, 197, is called a circular prime
 * because all rotations of the digits: 197, 971, and 719, are themselves prime.
 * 
 * There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71,
 * 73, 79, and 97.
 * 
 * How many circular primes are there below one million?
 * 
 * @author Chjun-chi
 *
 */
public class CircularPrimes {
	public static void main(String[] args) {
		int circularPrimes = 0;
		
		for (int i = 2; i < 1000000; i++) {
			HashSet<String> h = new HashSet<>();
			circlePermutaion(""+i, h);
		
			boolean isCircularPrime=false;
			for (String string : h) {
				if(checkPrime(Long.parseLong(string))) {
					isCircularPrime = true;
				}else {
					isCircularPrime = false;
					break;
				}
			}
			if (isCircularPrime) {
				circularPrimes++;
			}


		}
System.out.println("Circular Primes: "+ circularPrimes);
	}

	public static void circlePermutaion(String s, HashSet<String> h) {
		while (!h.contains(s)) {
			h.add(s);
			s = s.substring(1) + s.substring(0, 1);
		}
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
