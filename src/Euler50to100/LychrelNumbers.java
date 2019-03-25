package Euler50to100;

import java.math.BigInteger;
import Euler1to50.Timer;

/**
 * Problem 55 If we take 47, reverse and add, 47 + 74 = 121, which is
 * palindromic.
 * 
 * Not all numbers produce palindromes so quickly. For example,
 * 
 * 349 + 943 = 1292, 1292 + 2921 = 4213 4213 + 3124 = 7337
 * 
 * That is, 349 took three iterations to arrive at a palindrome.
 * 
 * Although no one has proved it yet, it is thought that some numbers, like 196,
 * never produce a palindrome. A number that never forms a palindrome through
 * the reverse and add process is called a Lychrel number. Due to the
 * theoretical nature of these numbers, and for the purpose of this problem, we
 * shall assume that a number is Lychrel until proven otherwise. In addition you
 * are given that for every number below ten-thousand, it will either (i) become
 * a palindrome in less than fifty iterations, or, (ii) no one, with all the
 * computing power that exists, has managed so far to map it to a palindrome. In
 * fact, 10677 is the first number to be shown to require over fifty iterations
 * before producing a palindrome: 4668731596684224866951378664 (53 iterations,
 * 28-digits).
 * 
 * Surprisingly, there are palindromic numbers that are themselves Lychrel
 * numbers; the first example is 4994.
 * 
 * How many Lychrel numbers are there below ten-thousand?
 * 
 * NOTE: Wording was modified slightly on 24 April 2007 to emphasise the
 * theoretical nature of Lychrel numbers.
 * 
 * @author chjunchi
 *
 */
public class LychrelNumbers {

	public static void main(String[] args) {
		Timer t = new Timer();
		int lychrels=0;
		for (int i = 1; i < 10000; i++) {
			int loop = 0;
			boolean lych=true;
			BigInteger nr = new BigInteger(String.valueOf(i));
			if (isPalindrome(nr.toString())) {
				String r = reverse(nr.toString());
				nr = nr.add(new BigInteger(r));
				loop++;
			}
			while (loop<50) {	
				if (isPalindrome(nr.toString())) {
					lych=false;
					break;
				}else {
					String r = reverse(nr.toString());
					nr = nr.add(new BigInteger(r));
				}
				loop++;
			}if (lych) {
				lychrels++;
			}
		}
		System.out.println("Lychrels: "+lychrels);
		t.time();
	}
	
	public static String reverse(String nr) {
		
		StringBuilder reverse =new StringBuilder();
		for (int i = nr.length() - 1; i >= 0; i--) {
			reverse.append(nr.charAt(i));
		}
		String r = reverse.toString();
		return r;
	}
	public static boolean isPalindrome(String nr) {
		for (int i = 0, k = nr.length() - 1, size = nr.length()
				/ 2; i < size; i++, k--) {
			if (!nr.substring(i, i + 1).contentEquals(nr.substring(k, k + 1))) {
				return false;
			}
		}
		return true;
	}
}
