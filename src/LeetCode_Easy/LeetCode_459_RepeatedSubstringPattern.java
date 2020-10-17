package LeetCode_Easy;

public class LeetCode_459_RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        for (int periodLength = 1; periodLength <= chars.length / 2; periodLength++) {
            boolean repeated = false;
            if (chars.length % periodLength == 0) {
                for (int i = 0; i < chars.length - periodLength; i++) {
                    if (chars[i] != chars[i + periodLength]) {
                        repeated = false;
                        break;
                    } else {
                        repeated = true;
                    }
                }
            }
            if (repeated) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("aabaaba"));
    }
}
