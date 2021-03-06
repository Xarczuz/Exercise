package Euler1to50;
import java.util.ArrayList;

public class SmallestMultiple {

	public static void main(String[] args) {

		long start2 = System.currentTimeMillis();
		sm();
		long end2 = System.currentTimeMillis();
		System.out.println((end2 - start2) + "ms");

		long start = System.currentTimeMillis();
		smp();
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

	/**
	 * Brute Force my version
	 */
	public static void sm() {
		int n = 20;
		int idx = 0;
		int nr = 1;
		while (true) {
			
			for (int i = 1; i <= n; i++) {
				if (nr % i == 0) {
					idx++;
					if (idx == n) {
						System.out.println((nr));
						return;
					}
				} else {
					idx = 0;
					nr++;
					break;
				}
			}

		}
	}

	/**
	 * Multiply the greatest power of each prime:
	 */
	public static void smp() {
		int n = 20;
		ArrayList<Integer> x = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			int number = i;
			for (int g : x) {
				if (number % g == 0) {
					number /= g;
				}
			}
			if (number != 1) {
				x.add(number);
			}
		}
//		12345678910 11121314151617181920
//		i=10
//		2*3*2*5*2*7*2*3*2

		long result = 1;
		for (int number : x) {
			result *= number;
		}
		System.out.println(result);

	}
}
