package Euler1to50;

import java.util.HashSet;

/**
 * @author Chjun-chi
 * 
 * @Problem32 We shall say that an n-digit number is pandigital if it makes use
 *            of all the digits 1 to n exactly once; for example, the 5-digit
 *            number, 15234, is 1 through 5 pandigital.
 * 
 *            The product 7254 is unusual, as the identity, 39 � 186 = 7254,
 *            containing multiplicand, multiplier, and product is 1 through 9
 *            pandigital.
 * 
 *            Find the sum of all products whose multiplicand/multiplier/product
 *            identity can be written as a 1 through 9 pandigital.
 * 
 *            HINT: Some products can be obtained in more than one way so be
 *            sure to only include it once in your sum.
 */
public class PandigitalProducts {

	public static void main(String[] args) {
		Timer t = new Timer();
		HashSet<Long> array = new HashSet<>();
		for (long i = 1; i < 100000; i++) {
			for (long j = 1; j < i/2; j++) {
				if (i % j == 0) {
					long p = i / j;
					String s = "" + p + "" + i + "" + j;
					if (s.length() <10) {
						if (ifPandigital(s)) {
							System.out.println(s);
							array.add(i);
						}		
					}else {
						break;
					}
				
				}
			}
		}
		System.out.println(array.toString());
		long sum = 0;
		for (Long nr : array) {
			sum += nr;
		}
		System.out.println("Sum: " + sum);
		t.time();
	}

	public static boolean ifPandigital(String s) {
		HashSet<String> p = new HashSet<>(9);
		p.add("1");
		p.add("2");
		p.add("3");
		p.add("4");
		p.add("5");
		p.add("6");
		p.add("7");
		p.add("8");
		p.add("9");

		for (int i = 0; i < s.length(); i++) {
			String o = s.substring(i, i + 1);
			if (p.contains(o)) {
				p.remove(o);
			} else {
				return false;
			}
		}
		if (p.size() == 0) {
			return true;
		}
		return false;
	}

}
