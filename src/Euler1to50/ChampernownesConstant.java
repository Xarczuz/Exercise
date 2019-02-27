package Euler1to50;

/**
 * Problem 40 An irrational decimal fraction is created by concatenating the
 * positive integers:
 * 
 * 0.123456789101112131415161718192021...
 * 
 * It can be seen that the 12th digit of the fractional part is 1.
 * 
 * If dn represents the nth digit of the fractional part, find the value of the
 * following expression.
 * 
 * d1 � d10 � d100 � d1000 � d10000 � d100000 � d1000000
 * 
 * 
 * 
 * @author Chjun-chi
 *
 */
public class ChampernownesConstant {

	public static void main(String[] args) {
		Timer t = new Timer();
		StringBuilder s = new StringBuilder();
		for (int i = 0; s.length() <= 1000000; i++) {
			s.append(i);			
		}
		int sum = 1;
		for (int i = 1; i <= 1000000; i = i * 10) {
			sum *= Integer.parseInt(s.substring(i, i + 1));
		}
		System.out.println("D sum: " + sum);
		t.time();
	}

}
