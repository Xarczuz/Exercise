package LeetCode_Easy;

public class LeetCode_581_ShortestUnsortedContinuousSubarray {

    static public int findUnsortedSubarray2(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;

        for (int i = 0; i < nums.length - 1; i++) {
            int pos = nums[i];
            boolean found = false;
            for (int j = i + 1; j < nums.length; j++) {
                if (pos > nums[j]) {
                    start = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        for (int i = nums.length - 1; i > 0; i--) {
            int pos = nums[i];
            boolean found = false;
            for (int j = i - 1; j >= 0; j--) {
                if (pos < nums[j]) {
                    end = i;
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
            end--;
        }

        // System.out.println(start + "-" + end);
        if (end == 0 && start == 0) {
            return 0;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray2(new int[]{2, 1}));
        System.out.println(findUnsortedSubarray2(new int[]{2, 3}));
        System.out.println(findUnsortedSubarray2(new int[]{3, 3, 3}));
        System.out.println(findUnsortedSubarray2(new int[]{1, 2, 3}));
        System.out.println(findUnsortedSubarray2(new int[]{3, 2, 1}));
        System.out.println(findUnsortedSubarray2(new int[]{1, 3, 2, 1}));
        System.out.println(findUnsortedSubarray2(new int[]{1, 3, 3, 3}));
        System.out.println(findUnsortedSubarray2(new int[]{1, 3, 2, 1, 1, 3, 2, 55, 99, 55}));
    }
}
