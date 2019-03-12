package Misc;

public class Leet4 {

	public static void main(String[] args) {
		Solution.findMedianSortedArrays(new int[]{1,  3},
				new int[]{2});
	}
	static class Solution {
		public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
			double median = 0;
			int size = nums1.length + nums2.length;
			int[] num3 = new int[size];
			if (size % 2 == 0) {
				int m = (size / 2) - 1;
				int n = m + 1;

				int i = 0, j = 0, k = 0;
				while (true) {
					if (i < nums1.length && j < nums2.length
							&& nums1[i] < nums2[j]) {
						num3[k] = nums1[i];
						i++;
					} else {
						num3[k] = nums2[j];
						j++;
					}
					k++;
					if (k == size) {
						System.out.println(num3[m] + "-" + num3[n]);
						median = (((double) (num3[m] + num3[n])) / 2);
						break;
					}
				}
			} else {
				int m = size/2;
	
				int i = 0, j = 0, k = 0;
				while (true) {
					if (i < nums1.length && j < nums2.length
							&& nums1[i] < nums2[j]) {
						num3[k] = nums1[i];
						i++;
					} else if( j < nums2.length){
						num3[k] = nums2[j];
						j++;
					}
					k++;
					if (k == size) {
						median =  (num3[m]);
						break;
					}
				}
				
			}
			System.out.println("median: " + median);
			return median;
		}
	}
}
