package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_345_ReverseVowelsofaString {

    public static String reverseVowels(String s) {
        //A, E, I, O, U
        char left = '%';
        char right = '%';
        int leftIndex = -1;
        int rightIndex = -1;
        char[] chars = s.toCharArray();
        for (int i = 0, j = s.length() - 1; i <= j; ) {
            if (left != '%' && right != '%') {
                char temp = chars[leftIndex];
                chars[leftIndex] = chars[rightIndex];
                chars[rightIndex] = temp;
                left = '%';
                right = '%';
                i++;
                j--;
                continue;
            }
            if (left == '%' && isVowel(chars[i])) {
                leftIndex = i;
                left = chars[i];
            } else if (left == '%') {
                i++;
            }
            if (right == '%' && isVowel(chars[j])) {
                rightIndex = j;
                right = chars[j];
            } else if (right == '%') {
                j--;
            }

        }
        return new String(chars);
    }

    private static boolean isVowel(char aChar) {
        switch (aChar) {
            case 'a':
            case 'u':
            case 'o':
            case 'i':
            case 'e':
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello")); //"holle"
        System.out.println(reverseVowels("leetcode")); //"leotcede"
        System.out.println(reverseVowels("aaoo")); //"ooaa"
        System.out.println(reverseVowels("a.")); //"ooaa"
    }
}
