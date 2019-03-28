package Euler50to100;

import java.util.HashSet;
import Euler1to50.Timer;

/**
 * Problem 61
 * 
 * 
 * @author Chjun-chi
 *
 */
public class CyclicalFigurateNumbers {

	public static void main(String[] args) {
		Timer t = new Timer();
		run();
		t.time();
	}

	public static void run() {
		HashSet<Integer> cylincal = new HashSet<>();
		HashSet<Integer> tria = new HashSet<>();
		HashSet<Integer> squa = new HashSet<>();
		HashSet<Integer> pent = new HashSet<>();
		HashSet<Integer> hexa = new HashSet<>();
		HashSet<Integer> hept = new HashSet<>();
		HashSet<Integer> octa = new HashSet<>();
		for (int n = 1; n < 10000; n++) {
			int sum = 0;
			sum = triangle(n);
			if (sum > 20000) {
				break;
			}

			tria.add(sum);
			cylincal.add(sum);

			sum = square(n);
			squa.add(sum);
			cylincal.add(sum);

			sum = pentagonal(n);
			pent.add(sum);
			cylincal.add(sum);

			sum = hexagonal(n);
			hexa.add(sum);
			cylincal.add(sum);

			sum = heptagonal(n);
			hept.add(sum);
			cylincal.add(sum);

			sum = octagonal(n);
			octa.add(sum);
			cylincal.add(sum);

		}

		for (Integer key : cylincal) {

			if (key <= 10000 && key >= 1000) {

				String s = cyn(key);

				for (Integer key2 : cylincal) {
					if (String.valueOf(key2).matches(s + "..")) {
						String s2 = cyn(key2);
						for (Integer key3 : cylincal) {
							if (String.valueOf(key3).matches(s2 + "..")) {
								String s3 = cyn(key3);
								for (Integer key4 : cylincal) {
									if (String.valueOf(key4)
											.matches(s3 + "..")) {
										String s4 = cyn(key4);
										for (Integer key5 : cylincal) {
											if (String.valueOf(key5)
													.matches(s4 + "..")) {
												String s5 = cyn(key5);
												for (Integer key6 : cylincal) {
													if (String.valueOf(key6)
															.matches(s5
																	+ "..")) {
														String s6 = cyn(key6);
														if (s6.matches(String
																.valueOf(key)
																.substring(0,
																		2))) {

															int[] keys = new int[]{
																	key, key2,
																	key3, key4,
																	key5, key6};
															boolean tri = false,
																	squ = false,
																	pen = false,
																	hex = false,
																	hep = false,
																	oct = false;
															for (int i = 0; i < keys.length; i++) {
																if (tria.contains(
																		keys[i])) {
																	tri = true;
																}
																if (squa.contains(
																		keys[i])) {
																	squ = true;
																}
																if (pent.contains(
																		keys[i])) {
																	pen = true;
																}
																if (hexa.contains(
																		keys[i])) {
																	hex = true;
																}
																if (hept.contains(
																		keys[i])) {
																	hep = true;
																}
																if (octa.contains(
																		keys[i])) {
																	oct = true;
																}
															}
															if (tri && squ
																	&& pen
																	&& hex
																	&& hep
																	&& oct) {
																System.out
																		.println(
																				"keys:" + key
																						+ " "
																						+ key2
																						+ " "
																						+ key3
																						+ " "
																						+ key4
																						+ " "
																						+ key5
																						+ " "
																						+ key6);
																System.out
																		.println(
																				"Sum of cyclical values: "
																						+ (key + key2
																								+ key3
																								+ key4
																								+ key5
																								+ key6));
																return;
															}

														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}
	public static String cyn(int key) {
		String n1 = String.valueOf(key);
		String n2 = n1.substring(2);
		return n2;
	}

	public static int triangle(int n) {
		return (n * (n + 1)) / 2;
	}
	public static int square(int n) {
		return n * n;
	}
	public static int pentagonal(int n) {
		return (n * (3 * n - 1)) / 2;
	}
	public static int hexagonal(int n) {
		return n * (2 * n - 1);
	}
	public static int heptagonal(int n) {
		return (n * (5 * n - 3)) / 2;
	}
	public static int octagonal(int n) {
		return n * (3 * n - 2);
	}
}
