package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_1051_HeightChecker {
    public int heightChecker(int[] heights) {
        int[] sorted = heights.clone();
        Arrays.sort(sorted);
        int needsToMove = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != sorted[i]) {
                needsToMove++;
            }
        }
        return needsToMove;
    }
}
