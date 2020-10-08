package LeetCode_Easy;

public class LeetCode_278_FirstBadVersion {
    static int badVersion = 1702766719;

    public static boolean isBadVersion(int version) {
        if (version >= badVersion) {
            return true;
        }
        return false;
    }

    static int minBad;

    public static int firstBadVersion(int n) {
        minBad = n;
        if (isBadVersion(n / 2)) {
            minBad = Math.min(minBad, n / 2);
            findMin(1, (n / 2));
        } else {
            findMin((n / 2) + 1, n);
        }
        return minBad;
    }

    private static void findMin(int i, int i1) {
        if (i == i1) {
            minBad = Math.min(minBad, i1);
            return;
        }
        int mid = (int) (((long) i + (long) i1) / 2);
        if (isBadVersion(mid)) {
            findMin(1, mid);
        } else {
            findMin((mid + 1), i1);
        }
    }

    public int firstBadVersion2(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int middle = (int) (((long) low + (long) high) / 2);
            if (isBadVersion(middle)) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }

        }
        return low;

    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));
    }
}
