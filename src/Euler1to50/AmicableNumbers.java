package Euler1to50;

import java.util.HashMap;

public class AmicableNumbers {

	public static void main(String[] args) {

		HashMap<Integer, Integer> list = new HashMap<>();
		for (int i = 1; i < 10001; i++) {

			int a = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0) {
					a += j;
				}
			}
			int b = 0;
			for (int j = 1; j < a; j++) {
				if (a % j == 0) {
					b += j;
				}
			}
			if (i == b && a != b) {
				list.put(a, b);
				list.put(b, a);
			}

		}
		System.out.println(list.toString());
		int totalSum = 0;
		for (int amicable : list.keySet()) {
			totalSum += amicable;
		}
		System.out.println(totalSum);
	}

}
