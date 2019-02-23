package Euler1_50;


import java.util.HashSet;

/**
 * Pandigital prime Problem 41 We shall say that an n-digit number is pandigital
 * if it makes use of all the digits 1 to n exactly once. For example, 2143 is a
 * 4-digit pandigital and is also prime.
 * 
 * What is the largest n-digit pandigital prime that exists?
 * 
 * 
 * 
 * @author Chjun-chi
 *
 */
public class PandigitalPrime {

	public static void main(String[] args) {
		Timer t = new Timer();
		for (long i = 7654321; i > 0; i--) {
			if (i % 2 != 0 && i % 3 != 0 && ifPandigital(String.valueOf(i))
					&& checkPrime(i)) {
				System.out.println("Largest pandigital prime: " + i);
				t.time();
				return;
			}
		}
	}

	public static boolean ifPandigital(String s) {
		HashSet<String> p = new HashSet<>(9);

		for (int i = 1; i <= s.length(); i++) {
			p.add(String.valueOf(i));
		}
		for (int i = 0; i < s.length(); i++) {
			String o = s.substring(i, i + 1);
			if (p.contains(o)) {
				p.remove(o);
			} else {
				return false;
			}
			if (p.size() == 0) {
				return true;
			}
		}
		return false;

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
