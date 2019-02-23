package Euler1_50;

import java.util.ArrayList;


/**
 * 
 * Sub-string divisibility Problem 43 The number, 1406357289, is a 0 to 9
 * pandigital number because it is made up of each of the digits 0 to 9 in some
 * order, but it also has a rather interesting sub-string divisibility property.
 * 
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note
 * the following:
 * 
 * d2d3d4=406 is divisible by 2 d3d4d5=063 is divisible by 3 d4d5d6=635 is
 * divisible by 5 d5d6d7=357 is divisible by 7 d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13 d8d9d10=289 is divisible by 17 Find the sum of
 * all 0 to 9 pandigital numbers with this property.
 * 
 * @author Chjun-chi
 *
 */
public class Sub_stringDivisibility {

	public static void main(String[] args) {
		Timer t = new Timer();
		permutation();
		t.time();
	}
	private static ArrayList<Integer> org = new ArrayList<>();
	public static void permutation() {
		org.add(0);
		org.add(1);
		org.add(2);
		org.add(3);
		org.add(4);
		org.add(5);
		org.add(6);
		org.add(7);
		org.add(8);
		org.add(9);
		long totSum = 0;
		int count = 1;
		System.out.println(org);
		while (count < 3628800) {
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
			if (org.get(0) == 0) {
				continue;
			}

			int s1 = Integer.parseInt(String.valueOf(org.get(1))
					.concat(String.valueOf(org.get(2)))
					.concat(String.valueOf(org.get(3))));
			if (s1 % 2 != 0)
				continue;

			int s2 = Integer.parseInt(String.valueOf(org.get(2))
					.concat(String.valueOf(org.get(3)))
					.concat(String.valueOf(org.get(4))));
			if (s2 % 3 != 0)
				continue;
			int s3 = Integer.parseInt(String.valueOf(org.get(3))
					.concat(String.valueOf(org.get(4)))
					.concat(String.valueOf(org.get(5))));
			if (s3 % 5 != 0)
				continue;
			int s4 = Integer.parseInt(String.valueOf(org.get(4))
					.concat(String.valueOf(org.get(5)))
					.concat(String.valueOf(org.get(6))));
			if (s4 % 7 != 0)
				continue;
			int s5 = Integer.parseInt(String.valueOf(org.get(5))
					.concat(String.valueOf(org.get(6)))
					.concat(String.valueOf(org.get(7))));
			if (s5 % 11 != 0)
				continue;
			int s6 = Integer.parseInt(String.valueOf(org.get(6))
					.concat(String.valueOf(org.get(7)))
					.concat(String.valueOf(org.get(8))));
			if (s6 % 13 != 0)
				continue;
			int s7 = Integer.parseInt(String.valueOf(org.get(7))
					.concat(String.valueOf(org.get(8)))
					.concat(String.valueOf(org.get(9))));
			if (s7 % 17 != 0)
				continue;

			totSum += Long.parseLong(org.get(0) + "" + org.get(1) + ""
					+ org.get(2) + "" + org.get(3) + "" + org.get(4) + ""
					+ org.get(5) + "" + org.get(6) + "" + org.get(7) + ""
					+ org.get(8) + "" + org.get(9));

		}
		System.out.println("Total sum of all permutations 0-9 : " + totSum);

	}
	public static void swap(int i, int j) {
		int k = org.get(i);
		org.set(i, org.get(j));
		org.set(j, k);
	}

}
