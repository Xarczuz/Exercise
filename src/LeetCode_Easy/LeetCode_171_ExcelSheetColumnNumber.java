package LeetCode_Easy;

public class LeetCode_171_ExcelSheetColumnNumber {

    public static int titleToNumber(String s) {
        int multiplier = 0;
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int nr = s.charAt(i) - 'A' + 1;
            for (int j = 0; j < multiplier; j++) {
                nr *= 26;
            }
            sum += nr;
            multiplier++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("AA"));
    }
}
