package Euler;

public class Largest_palindrome_product {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int n = 3;
		findLargetstPalindrome(nToNumber(n), n);
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

	public static void findLargetstPalindrome(int number, int n) {
		
		long max = 0;
		long k = 0;
		if (n % 2 == 0) {
			k = nToNumber(n / 2);
		} else {
			k = nToNumber((n + 1) / 2);
		}
		long it = number - k;

		for (long i = number; i >= it; i--) {
			for (long g = number; g >= it; g--) {
				long sum = i * g;
				if (sum > max && isPalindrome(sum)) {
					max = sum;
					System.out.println(max + "=" + i + "X" + g);
					break;
				}
			}
		}
	}

	public static boolean isPalindrome(long number) {
		String s1 = Long.toString(number);
		String reverse = "";
		for (int i = s1.length() - 1; i >= 0; i--) {
			reverse = reverse + s1.charAt(i);
		}
		if (s1.equals(reverse)) {
			return true;
		}
		return false;
	}

	public static int nToNumber(int n) {
		String nr = "";
		for (int i = 0; i < n; i++) {
			nr = nr + "9";
		}
		return Integer.parseInt(nr);
	}
}
