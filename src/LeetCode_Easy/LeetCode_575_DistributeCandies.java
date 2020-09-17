package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_575_DistributeCandies {

    public int distributeCandies(int[] candies) {

        HashSet<Integer> hashSet = new HashSet<>(candies.length);
        for (int i : candies) {
            hashSet.add(i);
        }
        return Math.min(candies.length / 2, hashSet.size());

    }

}
