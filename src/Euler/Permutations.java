package Euler;

import java.util.ArrayList;

public class Permutations {

	public static ArrayList<Integer> org = new ArrayList<>();
	public static void main(String[] args) {
		 
		org.add(1);
		org.add(7);
		org.add(9);
		
		int count = 0;
		System.out.println(org);
		while (count < org.size()) {
			int N = org.size();
			int i = N - 1;
			while (org.get(i - 1) >= org.get(i)) {
				i = i - 1;

			}
			int j = N;
			while (org.get(j - 1) <= org.get(i - 1)) {
				j = j - 1;
			}
			// swap values at position i-1 and j-1
			swap(i - 1, j - 1);

			i++;
			j = N;
			while (i < j) {
				swap(i - 1, j - 1);
				i++;
				j--;
			}
			count++;
			System.out.println(org);
			
		}
	}
	public static void swap(int i, int j) {
		int k = org.get(i);
		org.set(i, org.get(j));
		org.set(j, k);
	}
	
}
