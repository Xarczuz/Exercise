package Euler1_50;

/**
 * @author Chjun-chi
 *
 *         Starting with the number 1 and moving to the right in a clockwise
 *         direction a 5 by 5 spiral is formed as follows:
 * 
 *         21 22 23 24 25 20 7 8 9 10 19 6 1 2 11 18 5 4 3 12 17 16 15 14 13
 * 
 *         It can be verified that the sum of the numbers on the diagonals is
 *         101.
 * 
 *         What is the sum of the numbers on the diagonals in a 1001 by 1001
 *         spiral formed in the same way?
 * 
 * 
 */
public class NumberSpiralDiagonals {

	public static void main(String[] args) {
		int n = 1001;
		spiral(n);
	}

	public static void spiral(int n) {
		int gap = 1;
		int sum = 1;
		int count = 0;
		int step = 0;
		for (int i = 2; i <= n * n; i++) {
			if (step == gap) {
				sum += i;
				count++;
				step = 0;

			} else {
				step++;
			}
			if (count == 4) {
				gap += 2;
				count = 0;
			}
		}
		System.out.println("sum: " + sum);

	}

}
