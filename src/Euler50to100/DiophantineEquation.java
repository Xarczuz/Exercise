package Euler50to100;

import java.math.BigInteger;
import java.util.HashMap;

import Euler1to50.Timer;

/**
 * Problem 66
 * TODO
 * @author Chjun-chi
 *
 */
public class DiophantineEquation {

	public static void main(String[] args) {
		Timer t = new Timer();
		HashMap<Long, Long> squares = new HashMap<Long, Long>();
		for (long i = 1; i < 10000000; i++) {
			squares.put(i, i * i);
		}

		long biggestX = 0;
		long theD = 0;

		for (int D = 312; D <= 314; D++) {
			System.out.println("D is : " + D);
			double sqrt = Math.sqrt(D);
			if (sqrt - (int) sqrt == 0) {
				continue;
			}
			if (sqrt % 2 == 0) {
				continue;
			}
			for (long x = 1; x <= squares.size(); x++) {
				boolean found = false;
				for (long y = x; y > 0; y--) {
					long sum = 0;

					long X = squares.get(x);
					long DY = squares.get(y) * D;
					sum = X - DY;

					System.out.println("X:" + X + " Y:" + DY);
					System.out.println("SUM: " + sum);

					if (sum == 1) {
						System.out
								.println(x + "^2 - " + D + "X" + y + "^2 = 1");
						found = true;
						if (x > biggestX) {
							biggestX = x;
							theD = D;
						}
						break;
					}
					if (sum < 0) {
						break;
					}
				}
				if (found) {
					break;
				}
			}
		}
		System.out.println("The D:" + theD);
		t.time();
	}

}
