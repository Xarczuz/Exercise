package LeetCode_Easy;

public class LeetCode_896_MonotonicArray {
    public boolean isMonotonic(int[] A) {
        boolean monotoneIn;
        boolean monotoneDe;

        monotoneIn = monotoneIncreasing(A);
        monotoneDe = monotoneDecreasing(A);

        return monotoneIn || monotoneDe;
    }

    private boolean monotoneIncreasing(int[] a) {
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (!(prev <= a[i])) {
                return false;
            }
            prev = a[i];
        }
        return true;
    }

    private boolean monotoneDecreasing(int[] a) {
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (!(prev >= a[i])) {
                return false;
            }
            prev = a[i];
        }
        return true;
    }

}
