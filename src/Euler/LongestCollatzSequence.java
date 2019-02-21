	package Euler;

public class LongestCollatzSequence {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		longestCollatz();
		System.out.println((System.currentTimeMillis() - start) + "ms");
	}

	public static void longestCollatz() {
		int max = 0;
		int nr = 0;
		for (int i = 1; i < 1000000; i++) {
			int sum = collatz(i);
			if (sum > max) {
				max = sum;
				nr = i;
			}
		}
		System.out.println("Chains: " + max + " Nr: " + nr);
	}

	public static int collatz(long n) {
		int i = 1;
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = 3 * n + 1;
			}
			i++;
		}
		return i;
	}
}
