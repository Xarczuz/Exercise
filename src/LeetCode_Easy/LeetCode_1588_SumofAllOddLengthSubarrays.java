package LeetCode_Easy;

public class LeetCode_1588_SumofAllOddLengthSubarrays {

    public static int sumOddLengthSubarrays(int[] arr) {

        int sum = 0;
        int interval = 1;
        while (interval <= arr.length) {
            for (int i = 0; i + interval <= arr.length; i++) {
                for (int j = 0; j < interval; j++) {
                    sum += arr[i + j];
                }
            }
            interval += 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }
}
