package Euler1to50;

import java.math.BigInteger;
import java.util.ArrayList;

public class Permutations {

	public static void main(String[] args) {

		org.add(1);
		org.add(7);
		org.add(9);

	}
	public static ArrayList<Integer> org = new ArrayList<>();

	public static void permutaion() {
		System.out.println(org);
		int count = 0;
		while (count < org.size()) {
			int N = org.size();
			int i = N - 1;
			while (org.get(i - 1) >= org.get(i)) {
				i = i - 1;

			}
			int j = N;
			while (org.get(j - 1) <= org.get(i - 1)) {
				j = j - 1;
			}
			// swap values at position i-1 and j-1
			swap(i - 1, j - 1);

			i++;
			j = N;
			while (i < j) {
				swap(i - 1, j - 1);
				i++;
				j--;
			}
			count++;
			System.out.println(org);

		}
	}
	public static long factorial(int number) {
		long result = 1;

		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}

		return result;
	}

	public static BigInteger factorial(BigInteger number) {
		BigInteger result = BigInteger.valueOf(1);

		for (long factor = 2; factor <= number.longValue(); factor++) {
			result = result.multiply(BigInteger.valueOf(factor));
		}

		return result;
	}
	public static void swap(int i, int j) {
		int k = org.get(i);
		org.set(i, org.get(j));
		org.set(j, k);
	}

}
