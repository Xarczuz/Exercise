package LeetCode_Easy;

public class LeetCode_1189_MaximumNumberofBalloons {

    public int maxNumberOfBalloons(String text) {
        char[] chars = new char[26];
        char[] charText = text.toCharArray();
        for (char c : charText) {
            chars[c - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        min = Math.min(chars[0], min);
        min = Math.min(chars['b' - 'a'], min);
        min = Math.min(chars['l' - 'a'] / 2, min);
        min = Math.min(chars['o' - 'a'] / 2, min);
        min = Math.min(chars['n' - 'a'], min);
        return min;
    }
}
