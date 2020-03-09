package LeetCode_Easy;

public class LeetCode_657_RobotReturntoOrigin {
    public static boolean judgeCircle(String moves) {
        int vertical = 0;
        int horizontal = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                vertical++;
            } else if (moves.charAt(i) == 'D') {
                vertical--;
            } else if (moves.charAt(i) == 'L') {
                horizontal++;
            } else if (moves.charAt(i) == 'R') {
                horizontal--;
            }
        }
        return horizontal == 0 && vertical == 0;
    }

    public static void main(String[] args) {

        System.out.println(judgeCircle("LL"));
        System.out.println(judgeCircle("LLUURRDD"));
        System.out.println(judgeCircle("LLUURRDDD"));
    }
}
