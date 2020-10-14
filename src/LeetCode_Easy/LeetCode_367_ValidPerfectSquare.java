package LeetCode_Easy;

public class LeetCode_367_ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) {
            return true;
        }
        double d = Math.sqrt(num);
        return d - Math.floor(d) == 0;

    }
}
