package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_1299_ReplaceElementswithGreatestElementonRightSide {
    public static int[] replaceElements(int[] arr) {
        int biggest = arr[arr.length - 1];
        arr[arr.length - 1] = -1;
        for (int i = arr.length - 2; i >= 0; i--) {
            int val = arr[i];
            arr[i] = biggest;
            if (val > biggest) {
                biggest = val;
            }
        }
        return arr;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));

        System.out.println(Arrays.toString(replaceElements(new int[]{17, 1, 6, 7, 8, 5})));
        System.out.println(Arrays.toString(replaceElements(new int[]{20, 18, 19, 5, 8, 9})));
    }

}
