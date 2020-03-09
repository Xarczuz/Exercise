package LeetCode_Easy;

public class LeetCode_1266_MinimumTimeVisitingAllPoints {
    public static int minTimeToVisitAllPoints(int[][] points) {
        int x = points[0][0];
        int y = points[0][1];
        int total = 0;
        for (int i = 1; i < points.length; i++) {
            int diffX = 0;
            int diffY = 0;
            if (points[i][0] >= x) {
                diffX = points[i][0] - x;
            } else {
                diffX = x - points[i][0];
            }
            if (points[i][1] >= y) {
                diffY = points[i][1] - y;
            } else {
                diffY = y - points[i][1];
            }
            x = points[i][0];
            y = points[i][1];
            total += Math.max(diffX, diffY);
        }
        return total;
    }

    public static int minTimeToVisitAllPoints2(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length - 1; i++) {
            res += Math.max(Math.abs(points[i + 1][0] - points[i][0]),
                    Math.abs(points[i + 1][1] - points[i][1]));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
        System.out.println(minTimeToVisitAllPoints2(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
        System.out.println(minTimeToVisitAllPoints2(new int[][]{{3, 2}, {-2, 2}}));
    }
}
