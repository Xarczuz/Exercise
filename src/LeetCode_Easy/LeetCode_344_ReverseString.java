package LeetCode_Easy;

public class LeetCode_344_ReverseString {
    public void reverseString(char[] s) {
        int half = s.length / 2;
        for (int i = 0, j = s.length - 1; i < half; i++, j--) {
            char swap = s[i];
            s[i] = s[j];
            s[j] = swap;
        }
    }
}
