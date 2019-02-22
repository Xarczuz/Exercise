package Euler1_50;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Chjun-chi
 * 
 *         A permutation is an ordered arrangement of objects. For example, 3124
 *         is one possible permutation of the digits 1, 2, 3 and 4. If all of
 *         the permutations are listed numerically or alphabetically, we call it
 *         lexicographic order. The lexicographic permutations of 0, 1 and 2
 *         are:
 * 
 *         012 021 102 120 201 210
 * 
 *         What is the millionth lexicographic permutation of the digits 0, 1,
 *         2, 3, 4, 5, 6, 7, 8 and 9?
 * 
 * 
 * 
 */
public class LexicographicPermutations {

	public static HashMap<String, String> h = new HashMap<>();
	public static String orgin = "012"; // 0 1 2 3

	public static int fa = 0;
	public static ArrayList<Integer> org = new ArrayList<>();
	public static int index = 0;
	public static boolean end = false;
	public static void main(String[] args) {

		// String orgin = "0123";
		// String orgin2 ="0132";
		// String orgin3 ="0213";
		// String orgin4 ="0231";
		// String orgin5 ="0312";
		// String orgin6 ="0321";

		// 0123 0132 0213 0231 0312 0321
		// 1023 1032 1203 1230 1302 1320
		// 2013 2031 2103 2130 2301 2310
		// 3012 3021 3102 3120 3201 3210
		// 0,0 0,1 0,2
		// 1,0 1,1 1,2
		// 2,0 2,1 2,2

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

		//ArrayList<Integer> ss = new ArrayList<>();
		BigInteger p = factorial(org.size());
		fa = p.intValue();

		int count = 1;
		int numPerm = 1000000;
		while (count < numPerm) {
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
		}
		System.out.println(org);

		// done();

		// for (int i = 1; i <= org.size(); i++) {
		//
		// Collections.rotate(org, i);
		// permutaion3(org, org);
		//
		//
		// }
		// System.out.println(h.keySet());
		// done();
		// org.add(5);
		// 0 1 2 3
		// String orgin2 = "0132";// 0 1 3 2
		// String orgin5 = "0312";// 0 3 1 2
		// String orgin6 = "0321";// 0 3 2 1
		// String orgin4 = "0231";// 0 2 3 1
		// String orgin3 = "0213";// 0 2 1 3
		//
		// ArrayList<Integer> ss = new ArrayList<>();

		// while (h.size() != fa) {
		//
		// for (int i = org.size() - 1; 0 < i; i--) {
		// ss = (ArrayList<Integer>) org.clone();
		// Integer tmp = ss.get(org.size() - 1);
		// ss.remove(org.size() - 1);
		// ss.add(i, tmp);
		// //permutaion3(ss, ss);
		// String per = "";
		// for (int j = 0; j < ss.size(); j++) {
		// per += ss.get(j).toString();
		// }
		// System.out.println(per);
		// permutaion1(per);
		// }
		// org = (ArrayList<Integer>) ss.clone();
		//
		// }
		// done();
		// for (int i = org.size() - 1; 0 < i; i--) {
		// ss = (ArrayList<Integer>) org.clone();
		// ss.remove(org.size() - 1);
		// ss.add(i, org.size() - 1);
		//
		// permutaion3(ss, ss);
		//
		//
		// String per = "";
		// for (int j = 0; j < ss.size(); j++) {
		// per += ss.get(j).toString();
		// }
		// System.out.println(per);
		// permutaion1(per);
		// }
		// done();
		// permutaion1(orgin);
		// permutaion(orgin2);
		// permutaion(orgin3);
		// permutaion(orgin4);
		// permutaion(orgin5);
		// permutaion(orgin6);

		// ArrayList<String> sss = new ArrayList<>();
		// for (String string : h.keySet()) {
		// sss.add(string);
		// }
		// Collections.sort(sss);
		// System.out.println(sss);
		// System.out.println(h.size());
		// System.out.println(factorial(orgin.length()));
		// System.out.println(index);
	}
	public static void swap(int i, int j) {
		int k = org.get(i);
		org.set(i, org.get(j));
		org.set(j, k);
	}
	
	

	
	public static void permutaion1(String s) {
		// System.out.println(s);
		while (!h.containsKey(s)) {

			h.put(s, s);

			s = s.substring(1) + s.substring(0, 1);
		}

	}
	public static void permutaion2(String s) {

		while (!h.containsKey(s)) {
			h.put(s, s);
			s = s.substring(1) + s.substring(0, 1);
		}
	}
	@SuppressWarnings("unchecked")
	public static void permutaion3(ArrayList<Integer> org,
			ArrayList<Integer> ss) {

		while (h.size() != fa) {

			for (int i = org.size() - 1; 0 < i; i--) {
				ss = (ArrayList<Integer>) org.clone();
				Integer tmp = ss.get(org.size() - 1);
				ss.remove(org.size() - 1);
				ss.add(i, tmp);

				String per = "";
				for (int j = 0; j < ss.size(); j++) {
					per += ss.get(j).toString();
				}
				System.out.println(per);
				permutaion1(per);

			}
			org = (ArrayList<Integer>) ss.clone();

		}

	}
	public static void done() {

		ArrayList<String> ss = new ArrayList<>();
		for (String string : h.keySet()) {
			ss.add(string);
		}
		Collections.sort(ss);

		System.out.println("***************************************");
		// System.out.println("ONE MILLION===>:" + ss.get(999999));
		System.out.println(ss);
		System.out.println("last index:" + ss.get(ss.size() - 1));
		System.out.println("H size: " + h.size());
		System.out.println("Factorial " + fa);
		System.out.println("index:" + index);
		System.out.println("***************************************");
	}
	public static BigInteger factorial(int n) {
		BigInteger sum = new BigInteger("1");
		for (long i = 1; i <= n; i++) {
			sum = sum.multiply(new BigInteger(i + ""));
		}
		return sum;
	}
}
