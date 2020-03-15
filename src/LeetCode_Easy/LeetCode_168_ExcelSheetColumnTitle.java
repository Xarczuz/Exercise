package LeetCode_Easy;

public class LeetCode_168_ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        char[] chars = {'Z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        while (n > 0) {
            int r = n % 26;
            if (n == 26) {
                sb.insert(0, chars[r]);
                break;
            }
            if (r == 0) {
                n--;
            }
            n /= 26;
            sb.insert(0, chars[r]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println(24 % 26);
        System.out.println(52 / 26);
        System.out.println(52 - 26);
    }
}
