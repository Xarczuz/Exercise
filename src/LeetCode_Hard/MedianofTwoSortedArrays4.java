package LeetCode_Hard;

public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int[] arr = new int[length];

        int i = 0;
        int j = 0;

        for (int k = 0; k < arr.length; k++) {
            int nr = 0;
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    nr = nums1[i];
                    i++;
                } else {
                    nr = nums2[j];
                    j++;
                }
            } else {
                if (i < nums1.length) {
                    nr = nums1[i];
                    i++;
                } else {
                    nr = nums2[j];
                    j++;
                }
            }
            arr[k] = nr;
        }
        int middle = length / 2;
        if (length % 2 == 0) {
            int index1 = middle;
            int index2 = middle - 1;

            return ((double) arr[index1] + arr[index2]) / 2;
        } else {
            return arr[middle];
        }

    }

    public static void main(String[] args) {
        new MedianofTwoSortedArrays4().findMedianSortedArrays(new int[]{1, 2, 4, 8, 16, 99, 999, 9999}, new int[]{1, 2, 3, 34, 56, 67});
    }
}
