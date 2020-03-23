package LeetCode_Medium;

import java.util.Arrays;

public class LeetCode_151_ReverseWordsinaString {
    public static void main(String[] args) {
        System.out.println(Arrays.toString("a good   example".split(" ")));
    }

    public String reverseWords(String s) {
        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i > 0; i--) {
            if (strings[i].length() != 0 && strings[i].charAt(0) != ' ') {
                sb.append(strings[i].trim());
                sb.append(" ");
            }
        }
        if (strings.length != 0 && strings[0].length() != 0 && strings[0].charAt(0) != ' ') {
            sb.append(strings[0].trim());
        } else {
            return sb.toString().trim();
        }
        return sb.toString();
    }
}
