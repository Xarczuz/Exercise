package Codility;

import java.util.ArrayList;

public class Codility {

	public static void main(String[] args) {

		// System.out.println(solution1(565));
		int[] A = new int[7];
		A[0] = 9;
		A[1] = 3;
		A[2] = 9;
		A[3] = 3;
		A[4] = 9;
		A[5] = 7;
		A[6] = 9;
		System.out.println(solution2(A));
	}

	public static int solution1(int n) {
		String s = Integer.toBinaryString(n);

		int j = 0;
		int k = 0;
		for (int i = 0; i < s.length(); i++) {

			if (s.substring(i, i + 1).equals("0")) {
				j++;

			} else {
				if (j >= 1 && s.substring(i, i + 1).equals("1")) {
					if (j > k) {

						k = j;
					}
					j = 0;
				}
			}
		}
		return k;
	}

	public static int solution2(int[] A) {
		ArrayList<Integer> ar = new ArrayList<>();

		for (int k = 0; k < A.length; k++) {

			if (ar.contains(A[k])) {
				ar.remove(ar.indexOf(A[k]));
			} else {
				ar.add(A[k]);
			}

		}
		return ar.get(0);
	}
}
