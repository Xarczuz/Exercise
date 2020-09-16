package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_475_Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (int i = 0; i < houses.length; i++) {
            int tempMax = Integer.MAX_VALUE;

            for (int j = 0; j < heaters.length; j++) {

                int nr = Math.abs(houses[i] - heaters[j]);
                if (nr > tempMax) {
                    break;
                } else {
                    tempMax = nr;
                }
            }

            max = Math.max(max, tempMax);
        }

        return max;
    }
}
