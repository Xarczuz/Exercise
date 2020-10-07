package LeetCode_Easy;

import java.util.stream.IntStream;

public class LeetCode_278_FirstBadVersion {
    static int badVersion = 4;

    public static boolean isBadVersion(int version) {
        if (version >= badVersion) {
            return true;
        }
        return false;
    }

    static int minBad;

    public static int firstBadVersion(int n) {
        minBad = n;
        int[] arr = IntStream.range(1, n).toArray();

        if (isBadVersion(n / 2)) {
            //  findMin(Arrays.copyOfRange(),1,n/2);
        } else {
            // findMin(Arrays.copyOfRange(),1,n/2);

        }

        return n;
    }

    public static void main(String[] args) {
        System.out.println(5 / 2);
    }
}
