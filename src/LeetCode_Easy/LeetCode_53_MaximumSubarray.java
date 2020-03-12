package LeetCode_Easy;

import java.util.LinkedList;

public class LeetCode_53_MaximumSubarray {

    public int maxSubArray(int[] nums) {

        LinkedList<Integer> list = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int sumOfArray = 0;
        for (int n : nums) {
            sumOfArray += n;
            sum += n;
            list.add(n);
            if (sum > max) {
                max = sum;
            }

            if (list.peekFirst() < n || sum < 0) {

                if (n + list.peekFirst() != sum) {
                    if (sum - list.peekFirst() < sum) {

                    } else {

                        sum = sum - list.pop();
                    }
                }

            }
        }

        while (!list.isEmpty()) {
            int nr = list.pop();
            if (nr > max) {
                max = nr;
            }
        }
        if (sumOfArray > max) {
            return sumOfArray;
        }
        return max;

    }

    public int maxSubArray2(int[] nums) {

        int max = 0;

        return max;
    }

    public static void main(String[] args) {
        LeetCode_53_MaximumSubarray obj = new LeetCode_53_MaximumSubarray();
//        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));//6
//        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, -41, 2, 1, -5, 4}));//4
//        System.out.println(obj.maxSubArray(new int[]{8, -19, 5, -4, 20}));//21
//        System.out.println(obj.maxSubArray(new int[]{-2, 1, -3, 4, 6, -1, 2, 1, -5, 44}));//51
        System.out.println(obj.maxSubArray(new int[]{1, 2, 3, 4, 5, -90, 4, 1, 5, 4, 88}));//102
    }
}
