package LeetCode_Easy;

public class LeetCode_1470_ShuffletheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[nums.length];
        boolean flip = true;
        int x = 0;
        int y = n;
        for (int i = 0; i < nums.length; i++) {
            if (flip) {
                arr[i] = nums[x];
                x++;
                flip = false;
            } else {
                arr[i] = nums[y];
                y++;
                flip = true;
            }
        }
        return arr;
    }
}
