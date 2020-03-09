package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_1356_SortIntegersbyTheNumberof1Bits {
    public static int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((t1, t2) ->
                {
                    int bits1 = countBits(t1);
                    int bits2 = countBits(t2);
                    if (bits1 > bits2) {
                        return 1;
                    } else if (bits1 == bits2) {
                        if (t1 > t2) {
                            return 1;
                        } else if (t2 > t1) {
                            return -1;
                        }
                        return 0;
                    }
                    return -1;
                }).mapToInt(integer -> integer)
                .toArray();
    }

    public static int[] sortByBits2(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted((t1, t2) ->
                {
                    int bits1 = Integer.bitCount(t1);
                    int bits2 = Integer.bitCount(t2);
                    if (bits1 > bits2) {
                        return 1;
                    } else if (bits1 == bits2) {
                        if (t1 > t2) {
                            return 1;
                        } else if (t2 > t1) {
                            return -1;
                        }
                        return 0;
                    }
                    return -1;
                }).mapToInt(integer -> integer)
                .toArray();
    }

    public static int countBits(int nr) {
        int count = 0;
        while (nr > 0) {
            if (nr % 2 == 1) {
                count++;
            }
            nr /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(sortByBits2(new int[]{10000, 10000}));
        System.out.println(sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
        System.out.println(sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19}));
        System.out.println(sortByBits(new int[]{10, 100, 1000, 10000}));
    }
}
