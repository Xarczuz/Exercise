package Codility;
import java.util.*;

public class CodilityLesson2 {

	public static void main(String[] args) {
		
		int[] A = { 3, 8, 9, 7, 6 };
		int k = 4;
		int[] B = new int [0];
	
		System.out.println(Arrays.toString(solution2(A, k)));
		System.out.println(Arrays.toString(solution2(B, 4)));

	}

	public int solution(int[] A) {

		HashMap<Integer, Integer> l = new HashMap<>();
		for (int i = 0; i < A.length; i++) {

			if (!l.containsKey(A[i])) {
				l.put(A[i], 1);
			} else {
				l.remove(A[i]);
			}
		}
		int t = 0;
		for (int i : l.keySet()) {
			t = i;
		}
		return t;
	}

	
//	[3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] 1
//	[6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9] 2 
//	[7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8] 3
//	[9, 7, 6, 3, 8] -> [8, 9, 7, 6, 3] 4
//  [8, 9, 7, 6, 3] -> [3, 8, 9, 7, 6] 5
//  [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7] 6
	public static int[] solution2(int[] A, int K) {

		if (A.length == K) {
			return A;
		}
		if(A.length == 0) {
			return A;
		}else if (K > A.length) {
			while (K > A.length) {
				K = K - A.length;
			}
		} 
		

		int[] nArr = new int[A.length];

		int i = K;

		for (int s = 0; s < A.length - K; i++, s++) {
			nArr[i] = A[s];
		}

		i = 0;
		for (int s = A.length - K; s < A.length; i++, s++) {
			nArr[i] = A[s];
		}

		return nArr;
	}
}
