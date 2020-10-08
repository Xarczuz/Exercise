package LeetCode_Easy;

public class LeetCode_1550_ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int counter = 0;
        for (int i : arr) {
            if (i % 2 != 0) {
                counter++;
                if (counter == 3) {
                    return true;
                }
            } else {
                counter = 0;
            }
        }
        return false;
    }

}
