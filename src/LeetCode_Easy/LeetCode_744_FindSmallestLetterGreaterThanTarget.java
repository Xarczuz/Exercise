package LeetCode_Easy;

public class LeetCode_744_FindSmallestLetterGreaterThanTarget {

    public static char nextGreatestLetter(char[] letters, char target) {
        int[] chars = new int[26];
        for (char c : letters) {
            chars[c - 'a']++;
        }
        int i = target + 1 -'a';
        while (true) {
            if (chars[i % 26] != 0) {
                return (char) ((i % 26) + 'a');
            }
            i++;
        }
    }

    public static void main(String[] args) {
        System.out.println(nextGreatestLetter(new char[]{'c', 'a', 'f', 'j'}, 'a'));
    }
}
