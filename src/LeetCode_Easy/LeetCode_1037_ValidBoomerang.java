package LeetCode_Easy;

public class LeetCode_1037_ValidBoomerang {

    public static boolean isBoomerang(int[][] p) {
        return (p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) != (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
    }

    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(isBoomerang(new int[][]{{2, 1}, {4, 2}, {16, 8}}));
        System.out.println(isBoomerang(new int[][]{{0, 0}, {0, 2}, {2, 1}}));
    }
}
