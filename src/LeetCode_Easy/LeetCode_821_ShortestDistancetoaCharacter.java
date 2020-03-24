package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_821_ShortestDistancetoaCharacter {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LeetCode_821_ShortestDistancetoaCharacter().shortestToChar("ekloveleetcode", 'e')));
        System.out.println(Arrays.toString(new LeetCode_821_ShortestDistancetoaCharacter().shortestToChar("segewgoxrldotvelexetcotddeky", 'o')));
    }

    public int[] shortestToChar(String S, char C) {
        int size = S.length();
        int lastIndex = S.length() - 1;
        int[] arr = new int[size];
        int[] arr1 = new int[size];
        char[] chars = S.toCharArray();
        int count = 1;
        for (int i = 0; i < size; i++) {
            if (chars[i] != C) {
                arr1[i] = count;
                count++;
            } else {
                count = 1;
            }
        }
        int[] arr2 = new int[size];
        count = 1;
        for (int i = lastIndex; i >= 0; i--) {
            if (chars[i] != C) {
                arr2[i] = count;
                arr[i] = Math.min(arr1[i], arr2[i]);
                count++;
            } else {
                count = 1;
            }
        }

        if (chars[0] != C) {
            arr[0] = arr2[0];
            for (int i = 1; i < size; i++) {
                if (chars[i] != C) {
                    arr[i] = arr2[i];
                } else {
                    break;
                }
            }
        }
        if (chars[lastIndex] != C) {
            arr[lastIndex] = arr1[lastIndex];
            for (int i = lastIndex; i >= 0; i--) {
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
