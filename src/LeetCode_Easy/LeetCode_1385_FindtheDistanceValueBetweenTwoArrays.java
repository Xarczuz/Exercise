package LeetCode_Easy;

public class LeetCode_1385_FindtheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int res = 0;
        for (int a : arr1) {
            boolean distance = true;
            for (int b : arr2) {
                int sum = Math.abs(a - b);
                if (sum <= d) {
                    distance = false;
                    break;
                }
            }
            if (distance) {
                res++;
            }
        }
        return res;
    }
}
