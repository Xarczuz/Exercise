package LeetCode_Easy;

public class LeetCode_1295_FindNumberswithEvenNumberofDigits {
    public int findNumbers(int[] nums) {
        int evenNr = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) {
                evenNr++;
            }
        }
        return evenNr;
    }

    public static int findNumbers2(int[] nums) {
        int evenNr = 0;
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            int num = 0;
            if (number < 100) {
                if (number < 10) {
                    num = 1;
                } else {
                    num = 2;
                }
            } else {
                if (number < 1000) {
                    num = 3;
                } else {
                    if (number < 10000) {
                        num = 4;
                    } else {
                        num = 5;
                    }
                }
            }
            if (num % 2 == 0) {
                evenNr++;
            }
        }
        return evenNr;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers2(new int[]{12, 345, 2, 6, 7896}));
    }
}

