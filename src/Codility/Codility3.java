package Codility;

public class Codility3 {

	public static void main(String[] args) {
		
		int[] A = new int[] { 3, 1, 2, 4, 3 };
		int[] B = new int[] { -1000, 1000 };
		Codility3 c = new Codility3();
		System.out.println(c.solution(A));
		System.out.println(c.solution(B));

	}

	public int solution(int[] A) {
		int sumA = 0;
		int sumB = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}
		for (int i = 0; i < A.length-1; i++) {
			sumB += A[i];
			sumA -= A[i];
			int s = Math.abs(sumA - sumB);

			if (s < diff) {
				diff = s;

			}

		}
		return diff;
	}

}
