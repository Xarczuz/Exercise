package LeetCode_Easy;

public class LeetCode_88_MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] copyOfNums1 = nums1.clone();

        int n1Index = 0;
        int n2Index = 0;
        int index = 0;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        while (n1Index != m && n2Index != n) {

            int nums1Digit = copyOfNums1[n1Index];
            int nums2Digit = nums2[n2Index];

            if (nums1Digit < nums2Digit) {
                nums1[index] = nums1Digit;
                n1Index++;
            } else {
                nums1[index] = nums2Digit;
                n2Index++;
            }
            index++;
        }
        if (n1Index < m) {
            while (index != (n + m)) {
                nums1[index] = copyOfNums1[n1Index];
                n1Index++;
                index++;
            }
        } else if (n2Index < n) {
            while (index != (n + m)) {
                nums1[index] = nums2[n2Index];
                n2Index++;
                index++;
            }
        }
    }

}
