package LeetCode_Easy;

public class LeetCode_1103_DistributeCandiestoPeople {

    public int[] distributeCandies(int candies, int num_people) {

        int[] res = new int[num_people];
        int n = 1;
        while (candies != 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies <= n) {
                    res[i] += candies;
                    candies = 0;
                    break;
                }
                candies -= n;
                res[i] += n;
                n++;
            }
        }
        return res;
    }

}
