package LeetCode_Easy;

public class LeetCode_69_SqrtX {
    public static int mySqrt(int x) {
        if (x == 2) {
            return 1;
        }
        int a = 1;
        while (a * a < x) {
            a++;
        }
        if (a * a > x) {
            a--;
        }
        return a;
    }

    public static void main(String[] args) {

        System.out.println(mySqrt(84897815));
    }
}
