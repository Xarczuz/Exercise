package Euler1_50;

public class SumSquareDifference {
	public static void main(String[] args) {
		int n = 100;
		System.out.println(squareSum(n) - sumSquare(n));
	}

	public static int sumSquare(int n) {
		if (n == 0) {
			return 0;
		}
		return sumSquare(n - 1) + (n * n);
	}

	public static int sum(int n) {
		if (n == 0) {
			return 0;
		}
		return sum(n - 1) + n;
	}

	public static int sum2(int n) {
		if (n == 0) {
			return 0;
		}
		return ((n + 1) * n) / 2;
	}

	public static int squareSum(int n) {
		int sum = sum2(n);
		return sum * sum;
	}
}

