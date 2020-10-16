package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_1033_MovingStonesUntilConsecutive {
    public int[] numMovesStones(int a, int b, int c) {
        int[] xyz = new int[]{a, b, c};
        Arrays.sort(xyz);
        int min = 0;
        int intervalXY = xyz[1] - xyz[0] - 1;
        int intervalYZ = xyz[2] - xyz[1] - 1;
        if (intervalXY > 1 && intervalYZ > 1) {
            min += 2;
        } else if (intervalXY + intervalYZ >= 1) {
            min++;
        }
        return new int[]{min, intervalXY + intervalYZ};
    }
}

