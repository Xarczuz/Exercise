package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_821_ShortestDistancetoaCharacter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_821_ShortestDistancetoaCharacter().shortestToChar("ekloveleetcode", 'e')));
        System.out.println(Arrays.toString(new LeetCode_821_ShortestDistancetoaCharacter().shortestToChar("segewgoxrldotvelexetcotddeky", 'o')));
    }

    public int[] shortestToChar(String S, char C) {
        int[] arr = new int[S.length()];
        int[] arr1 = new int[S.length()];
        char[] chars = S.toCharArray();
        int count = 1;
        for (int i = 0; i < arr1.length; i++) {
            if (chars[i] != C) {
                arr1[i] = count;
                count++;
            } else {
                count = 1;
            }
        }
        int[] arr2 = new int[S.length()];
        count = 1;
        for (int i = arr2.length - 1; i >= 0; i--) {
            if (chars[i] != C) {
                arr2[i] = count;
                count++;
            } else {
                count = 1;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            arr[i] = Math.min(arr1[i], arr2[i]);
        }
        if (chars[0] != C) {
            arr[0] = arr2[0];
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] != C) {
                    arr[i] = arr2[i];
                } else {
                    break;
                }
            }
        }
        if (chars[chars.length - 1] != C) {
            arr[chars.length - 1] = arr1[chars.length - 1];
            for (int i = chars.length - 1; i >= 0; i--) {
                if (chars[i] != C) {
                    arr[i] = arr1[i];
                } else {
                    break;
                }
            }
        }
        return arr;
    }
}
