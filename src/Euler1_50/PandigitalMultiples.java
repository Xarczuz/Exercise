package Euler1_50;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Pandigital multiples Problem 38 Take the number 192 and multiply it by each
 * of 1, 2, and 3:
 * 
 * 192 × 1 = 192 192 × 2 = 384 192 × 3 = 576 By concatenating each product we
 * get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated
 * product of 192 and (1,2,3)
 * 
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4,
 * and 5, giving the pandigital, 918273645, which is the concatenated product of
 * 9 and (1,2,3,4,5).
 * 
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as
 * the concatenated product of an integer with (1,2, ... , n) where n > 1?
 * 
 * @author Chjun-chi
 *
 */
public class PandigitalMultiples {

	public static void main(String[] args) {
long max=0;
long product =0;
		for (int i = 2; i < 100000; i++) {
			product = checkNr(i);
			
			if(product!=0) {
				if (product>max) {
					max= product;
				}
			}
			
		}
		System.out.println("Larget pandigital: "+max);
	}

	public static long checkNr(int nr) {
		ArrayList<Integer> ps = new ArrayList<>();
		int idx = 1;
		long product = 0;
		
		while (product < 1000000000) {
			ps.add(idx * nr);
			String cProduct = concatProduct(ps);
			product = Long.parseLong(cProduct);
			if (pandigital(cProduct)) {
				return product;
			}
			idx++;
		}

		
		return 0;

	}
	public static String concatProduct(ArrayList<Integer> p) {
		String pandigital = "";
		for (Integer integer : p) {
			pandigital += String.valueOf(integer);
		}
		return pandigital;
	}
	public static boolean pandigital(String pandigital) {

		HashSet<String> pan = new HashSet<>();
		pan.add("0");
		if (pandigital.length() == 9) {
			for (int i = 0; i < pandigital.length(); i++) {
				String temp = pandigital.substring(i, i + 1);

				if (!pan.contains(temp)) {
					pan.add(temp);
				} else {
					return false;
				}
			}
			System.out.println(pandigital);
			return true;
		} else {
			return false;
		}

	}
}
