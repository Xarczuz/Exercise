package Euler1_50;

import java.math.BigInteger;
import java.util.HashMap;

/**
 * The Class DistinctPowers.
 */
public class DistinctPowers {

	public static void main(String[] args) {
		long t1= System.currentTimeMillis();
		HashMap<BigInteger, Integer> map = new HashMap<>();
		for (int i = 2; i <= 100; i++) {
			BigInteger a = new BigInteger(""+i);
			for (int j = 2; j <= 100; j++) {
				map.put(a.pow(j), 0);
			}
		}
		System.out.println(map.keySet().size());
	System.out.println(System.currentTimeMillis()-t1);
	}
	
}
