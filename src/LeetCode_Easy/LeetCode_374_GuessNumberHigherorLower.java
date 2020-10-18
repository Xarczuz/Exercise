package LeetCode_Easy;

public class LeetCode_374_GuessNumberHigherorLower {

    public static int guessNumber(int n) {
        // 1 2 3 4 5 6 7 8 9 10 11
        int tryNr = n / 2, low = 1, high = n;
        while (true) {
            int result = guess(tryNr);
            if (result == 0) {
                return tryNr;
            } else if (result == 1) {
                low = tryNr + 1;
                tryNr = findMid(low, high);
            } else {
                high = tryNr - 1;
                tryNr = findMid(low, high);
            }
        }

    }

    private static int findMid(int i, int n) {
        long sum = (long) i + n;
        return (int) (sum / 2);
    }

    private static int guess(int i) {
        int nr = 1702766719;
        if (i < nr) {
            return 1;
        } else if (i > nr) {
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(2126753390));
    }
}
