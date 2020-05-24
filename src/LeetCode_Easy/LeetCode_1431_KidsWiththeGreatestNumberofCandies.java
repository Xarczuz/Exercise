package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_1431_KidsWiththeGreatestNumberofCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> arr = new ArrayList<>();
        int highest = 0;
        for (int nr : candies) {
            highest = Math.max(nr, highest);
        }
        for (int nr : candies) {
            arr.add((nr + extraCandies) >= highest);
        }
        return arr;
    }
}
