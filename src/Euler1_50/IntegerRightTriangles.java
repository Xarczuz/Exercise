package Euler1_50;

import java.util.HashMap;

/**
 * 
 * Integer right triangles Problem 39 If p is the perimeter of a right angle
 * triangle with integral length sides, {a,b,c}, there are exactly three
 * solutions for p = 120.
 * 
 * {20,48,52}, {24,45,51}, {30,40,50}
 * 
 * For which value of p ≤ 1000, is the number of solutions maximised?
 * 
 * @author Chjun-chi
 *
 */
public class IntegerRightTriangles {

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int a =1; a < 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				for (int c = 1; c < 1000; c++) {
					int key = a + b + c;
					if ((key<=1000)&& (a * a + b * b) == (c * c)) {
						if (map.containsKey(key)) {
							int value = map.get(key);
							map.put(key, ++value);
						} else {
							map.put(key, 1);
						}
					}

				}
			}
		}
		int max = 0;
		int p = 0;
		for (int key : map.keySet()) {
			int value = map.get(key);
			if (value > max) {
				max = value;
				p = key;
			}

		}
		System.out.println("Maximum p: " + p);

	}

}
