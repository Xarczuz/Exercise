package LeetCode_Easy;

public class LeetCode_326_PowerofThree {

    public boolean isPowerOfThree(int n) {
        if (n == 1) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

}
