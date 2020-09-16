package LeetCode_Easy;

public class LeetCode_1189_MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {
        char[] chars = new char[26];
        for (char c : text.toCharArray()) {
            chars[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(chars[0], min);
        min = Math.min(chars[1], min);
        min = Math.min(chars[11] / 2, min);
        min = Math.min(chars[13], min);
        min = Math.min(chars[14] / 2, min);
        return min;
    }
}
