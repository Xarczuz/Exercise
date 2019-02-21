package Codility;

public class CodilityLesson3 {

	public static void main(String[] args) {

		System.out.println(solution(5, 105, 3));
		int[] A = new int[4];
		A[0] = 2;
		A[1] = 3;
		A[2] = 1;
		A[3] = 5;

		System.out.println(solution2(A));
	}

	public static int solution(int X, int Y, int D) {

		int i = Y - X;
		if (i % D == 0) {
			return i / D;
		} else {
			return (i / D) + 1;
		}

	}

	public static int solution2(int[] A) {

		long n = A.length + 1;
		long sum = n * (n + 1) / 2;
		long sum2 = 0;
		for (int i = 0; i < A.length; i++) {
			sum2 += A[i];
		}

		return (int) (sum - sum2);
	}

}
