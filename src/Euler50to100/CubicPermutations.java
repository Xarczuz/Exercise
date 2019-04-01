package Euler50to100;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Euler1to50.Timer;

/**
 * Problem 62
 * 
 * 
 * @author Chjun-chi
 *
 */
public class CubicPermutations {

	public static void main(String[] args) {
		Timer t = new Timer();
		int startNr = 406,permutations = 0,lengthA = 8, lengthB = 8,target = 5;
		HashMap<String, Integer> listOfCubes = new HashMap<>();
		ArrayList<String> cubes = new ArrayList<>();
		
		while (permutations < target) {
			BigInteger nr = new BigInteger(String.valueOf(startNr));
			BigInteger cube = cube(nr);
			lengthA = cube.toString().length();
			if (lengthA > lengthB) {
				lengthB = lengthA;
				listOfCubes.clear();
				cubes.clear();
			}
			cubes.add(cube.toString());
			String s = sortCharArrayToString(cube.toString().toCharArray());
			if (listOfCubes.containsKey(s)) {
				int newValue = listOfCubes.get(s) + 1;
				listOfCubes.put(s, newValue);
				if (newValue == target) {
					for (int i = 0, size = cubes.size(); i < size; i++) {
						String s2 = sortCharArrayToString(cubes.get(i).toCharArray());
						if (s2.contentEquals(s)) {
							System.out.println(cubes.get(i));
							t.time();
							return;
						}
					}
				}
			} else {
				listOfCubes.put(s, 1);
			}
			startNr++;
		}

	}

	public static String sortCharArrayToString(char[] chars) {
		Arrays.sort(chars);
		StringBuilder sb = new StringBuilder();
		for (int j = 0, size2 = chars.length; j < size2; j++) {
			sb.append(String.valueOf(chars[j]));
		}
		return sb.toString();
	}
	public static BigInteger cube(BigInteger nr) {
		return nr.multiply(nr).multiply(nr);
	}

}
