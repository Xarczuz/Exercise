package LeetCode_Easy;

public class LeetCode_414_ThirdMaximumNumber {
    public int thirdMax(int[] nums) {
        long n1 = Long.MIN_VALUE;
        long n2 = Long.MIN_VALUE;
        long n3 = Long.MIN_VALUE;

        for (int num : nums) {
            if (n1 < num) {
                n3 = n2;
                n2 = n1;
                n1 = num;
            } else {
                if (num == n1 || num == n2 || num == n3) {
                    continue;
                }
                if (n2 < num) {
                    n3 = n2;
                    n2 = num;
                } else {
                    if (n3 < num) {
                        n3 = num;
                    }
                }
            }
        }
        if (n3 == Long.MIN_VALUE) {
            return (int) n1;
        }
        return (int) n3;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_414_ThirdMaximumNumber().thirdMax(new int[]{3, 2, 2, 1}));
        System.out.println(new LeetCode_414_ThirdMaximumNumber().thirdMax(new int[]{2, 1}));
        System.out.println(new LeetCode_414_ThirdMaximumNumber().thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(new LeetCode_414_ThirdMaximumNumber().thirdMax(new int[]{1, 2, -2147483648}));

    }
}
