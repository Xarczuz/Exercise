package LeetCode_Easy;

public class LeetCode_1566_DetectPatternofLengthMRepeatedKorMoreTimes {
    /*
    m = 3   k = 3

    ... 1 2 3 1 2 3 1 2 3 ...
        i --- j
    count = 1

    ... 1 2 3 1 2 3 1 2 3 ...
          i --- j
    count = 2

    ... 1 2 3 1 2 3 1 2 3 ...
            i --- j
    count = 3

    ... 1 2 3 1 2 3 1 2 3 ...
              i --- j
    count = 4

    ... 1 2 3 1 2 3 1 2 3 ...
                i --- j
    count = 5

    ... 1 2 3 1 2 3 1 2 3 ...
                  i --- j
    count = 6  ->  (k - 1) * m
    */
    public static boolean containsPattern(int[] arr, int m, int k) {
        for (int i = 0, j = i + m, count = 0; j < arr.length; ++i, ++j) {
            if (arr[i] != arr[j]) {
                count = 0;
            } else if (++count == (k - 1) * m) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsPattern(new int[]{1, 2, 1, 2, 1, 3, 4}, 2, 3));
        System.out.println(containsPattern(new int[]{2, 2, 2, 2}, 2, 3));
        System.out.println(containsPattern(new int[]{1, 2, 1, 2, 1, 1, 1, 3}, 2, 2));
        System.out.println(containsPattern(new int[]{1, 1, 1, 2, 1, 1, 1, 3}, 1, 6));
        System.out.println(containsPattern(new int[]{2, 2}, 1, 2));
        System.out.println(containsPattern(new int[]{1, 2, 3, 1, 2}, 2, 2));
        System.out.println(containsPattern(new int[]{2, 2, 1, 2, 2, 1, 1, 1, 2, 1}, 2, 2));
    }
}
