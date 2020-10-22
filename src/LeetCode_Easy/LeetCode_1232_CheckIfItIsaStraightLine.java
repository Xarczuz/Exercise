package LeetCode_Easy;

public class LeetCode_1232_CheckIfItIsaStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3) {
            return true;
        }
        for (int i = 0; i < coordinates.length - 2; i++) {
            if (!isLine(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0],
                    coordinates[i + 1][1], coordinates[i + 2][0], coordinates[i + 2][1])) {
                return false;
            }
        }
        return true;
    }

    private boolean isLine(int x1, int y1, int x2, int y2, int x3, int y3) {
        return x3 * (y2 - y1) - y3 * (x2 - x1) == x1 * y2 - x2 * y1;
    }
}
