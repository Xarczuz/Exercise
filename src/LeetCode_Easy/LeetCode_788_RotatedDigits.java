package LeetCode_Easy;

public class LeetCode_788_RotatedDigits {
    public static void main(String[] args) {
        System.out.println(new LeetCode_788_RotatedDigits().rotatedDigits(50));
        //16
    }

    public int rotatedDigits(int N) {
        int count = 0;
        int[] map = {0, 1, 5, -1, -1, 2, 9, -1, 8, 6};
        for (int i = 1; i <= N; i++) {
            boolean flag = true;
            int n = i;
            int n2 = 0;
            int ten = 1;
            while (n != 0) {
                int r = n % 10;
                if (map[r] < 0) {
                    flag = false;
                    break;
                }
                n2 = (map[r] * ten) + n2;
                ten *= 10;
                n /= 10;
            }
            if (flag && i != n2) {
                count++;
            }
        }
        return count;
    }

}
