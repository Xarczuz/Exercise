package LeetCode_Easy;

public class LeetCode_70_ClimbingStairs {
    public int climbStairs(int n) {
        int nr = 0;
        int prev = 1;
        int prevPrev = 0;
        for (int i = 1; i <= n; i++) {
            nr = prev + prevPrev;
            prevPrev = prev;
            prev = nr;
        }
        return nr;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_70_ClimbingStairs().climbStairs(5));
    }
}
