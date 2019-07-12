package Euler50to100;

import Euler1to50.Timer;

/**
 * Problem 64
 * 
 * @author Chjun-chi
 *
 */
public class OddPeriodSquareRoots {

	public static void main(String[] args) {
		Timer t = new Timer();
		int odd = 0;
		for (int n = 2; n <= 10000; n++) {
			int m = 0;
			int d = 1;
			int S = n;
			int a = (int) Math.sqrt(S);
			int A = a;
			// System.out.print("squareroot("+n+")"+a+":");
			if (a * a == n) {
				continue;
			}
			int period=0;
			while ( a < 2*A) {
				m = d * a - m;
				d = (S - m * m) / d;
				a = (A + m) / d;
				// System.out.print(a);
				period++;
			}
			// System.out.print(", period="+(i-1)/n);
			if ((period) % 2 != 0) {
				odd++;
			}
		}
		System.out.println("Exactly: " + odd + " have an odd period");
		t.time();
	
		int x=10;
		System.out.println((2 + x + 2*x^2 - 3*x^3 - x^4 + x^6)/(1 - 2*x^3 + x^6));
	}

}
