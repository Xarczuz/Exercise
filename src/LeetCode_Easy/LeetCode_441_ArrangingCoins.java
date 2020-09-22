package LeetCode_Easy;

public class LeetCode_441_ArrangingCoins {

    public static int arrangeCoins(int n) {
        return (int) ((-1 + Math.sqrt(1 + 8 * (long) n)) / 2);
    }

    public static int arrangeCoins2(int n) {
        // 1 1 2 2 2 3 3 3 3 4  4  4  4  4  5  5  5  5  5  5  6  6
        // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22
        if (n == 0) {
            return 0;
        }
        int index = 1;
        for (long i = 1; ; i += index) {
            System.out.println("index:" + index);
            System.out.println("i:" + i);
            if (i + index >= n) {
                break;
            } else {
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(2147483647));
    }
}
