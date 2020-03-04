package LeetCode_Easy;

public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        int i = 0;
        while (strs[0].length() != i) {
            char currentChar = strs[0].charAt(i);
            for (String s : strs) {
                if (i == s.length()) {
                    return prefix.toString();
                }
                if (s.charAt(i) != currentChar) {
                    return prefix.toString();
                }
            }
            prefix.append(currentChar);
            i++;
        }
        return prefix.toString();

    }
}
