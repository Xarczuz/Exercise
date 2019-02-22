package Euler1_50;

public class Double_basePalindromes {

	public static void main(String[] args) {
		Timer t = new Timer();
//		long total = 0;
//		for (int i = 1; i < 1000000; i++) {
//			if (isPalindrome(i, 10) && isPalindrome(i, 2)) {
//				total += i;
//			}
//		}
//		System.out.println(total);

		long limit = 1000000;
		long sum = 0;
		long i = 1;
		long p = makePalindromeBase2(i, true);
		while (p < limit) {
			if (isPalindrome(p, 10)) {
				sum += p;
			}
			i++;
			p = makePalindromeBase2(i, true);
		}
		
		i = 1;
		p = makePalindromeBase2(i, false);
		while (p < limit) {
			if (isPalindrome(p, 10)) {
				sum += p;
			}
			i++;
			p = makePalindromeBase2(i, false);
		}
		System.out.println(sum);

		t.time();
	}
	public static String nrToBinary(int quot) {
		String s = "";
		while (quot != 0) {
			s += (quot % 2);
			quot = quot / 2;
		}
		return s;
	}
	public static boolean isPalindrome(String number) {
		int sl = number.length();
		for (int i = 0; i < sl / 2; i++) {
			if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isPalindrome(long number, int bas) {
		long reversed = 0;
		long k = number;
		while (k > 0) {
			reversed = bas * reversed + k % bas;
			k = k / bas;
		}
		return (number == reversed);
	}

	public static long makePalindrome(long n, long base, Boolean odd) {
		long res = n;
		if (odd) {
			n = n / base;
		}
		while (n > 0) {
			res = base * res + n % base;
			n = n / base;
		}
		return res;
	}
	public static long makePalindromeBase2(long n, boolean odd) {
		long res = n;
		if (odd) {
			n = n >> 1;
		}
		while (n > 0) {
			res = (res << 1) +( n & 1);
			n = n >> 1;
		}
		return res;
	}
}
