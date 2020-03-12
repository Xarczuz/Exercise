package LeetCode_Easy;

public class LeetCode_1374_GenerateaStringWithCharactersThatHaveOddCounts {
    public String generateTheString(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 0) {
            sb.append('b');
            for (int i = 1; i < n; i++) {
                sb.append('a');
            }
        } else {
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
        }
        return sb.toString();

    }
}
