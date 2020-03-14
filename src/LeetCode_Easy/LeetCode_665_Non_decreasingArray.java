package LeetCode_Easy;

public class LeetCode_665_Non_decreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int count = 0;
        int prev = Integer.MIN_VALUE;
        int prevPrev = Integer.MIN_VALUE;
        for (int num : nums) {
            if (prev > num) {
                count++;
                if (count > 1) {
                    return false;
                }
                if (count == 1) {
                    if (prevPrev > num) {
                        continue;
                    }
                }
            }
            prevPrev = prev;
            prev = num;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_665_Non_decreasingArray().checkPossibility(new int[]{2, 3, 3, 3, 2, 4}));
        System.out.println(new LeetCode_665_Non_decreasingArray().checkPossibility(new int[]{4, 2, 1}));
        System.out.println(new LeetCode_665_Non_decreasingArray().checkPossibility(new int[]{4, 2, 3}));
        System.out.println(new LeetCode_665_Non_decreasingArray().checkPossibility(new int[]{4, 2, 3, 4, 5, 6, 7, 8, 9, 5, 9, 10}));
        System.out.println(new LeetCode_665_Non_decreasingArray().checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
