package LeetCode_Easy;

public class LeetCode_27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0 || (nums.length == 1 && nums[0] == val)) {
            return 0;
        }
        int pointer = nums.length - 1;
        for (int i = 0; i < pointer; i++) {
            if (nums[i] == val) {
                while (pointer > -1 && pointer != i) {
                    if (nums[pointer] != val) {
                        nums[i] = nums[pointer];
                        nums[pointer] = val;
                        pointer--;
                        break;
                    }
                    pointer--;
                }
            }

        }
        int length = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != val) {
//                System.out.println(Arrays.toString(nums));
//                System.out.println(nums.length - length);
                return nums.length - length;
            }
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        new LeetCode_27_RemoveElement().removeElement(new int[]{3, 2, 2, 3}, 3);
        new LeetCode_27_RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        new LeetCode_27_RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2, 5, 7, 3, 2, 6, 73, 56, 74, 2, 1, 6, 8, 5}, 1);
        new LeetCode_27_RemoveElement().removeElement(new int[]{1}, 1);
        new LeetCode_27_RemoveElement().removeElement(new int[]{1, 1}, 1);
        new LeetCode_27_RemoveElement().removeElement(new int[]{4, 1}, 1);
    }
}
