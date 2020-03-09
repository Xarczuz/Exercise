package LeetCode_Easy;

public class LeetCode_652_PeakIndexinaMountainArray {

    // NO NEED TO CHECK MULTIPLE PEAKS
    public int peakIndexInMountainArray(int[] A) {
        int nr = 0;
        int peak = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (nr > A[i]) {
                if (nr > max) {
                    max = nr;
                    peak = i - 1;
                }
            }
            nr = A[i];
        }
        return peak;
    }
}
