package LeetCode_Easy;

public class LeetCode_941_ValidMountainArray {
    static public boolean validMountainArray(int[] A) {

        if (A.length < 3) {
            return false;
        }
        boolean top = false;
        boolean bot = false;
        int i = 0;
        for (; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (top) {
                    return false;
                }
                bot = true;
                continue;
            } else if (A[i] > A[i + 1]) {
                top = true;
                continue;
            }
            if (A[i] == A[i + 1]) {
                return false;
            }

        }
        return bot && top;
    }

}
