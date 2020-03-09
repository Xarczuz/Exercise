package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_804_UniqueMorseCodeWords {
    public static int uniqueMorseRepresentations(String[] words) {
        String[] strings = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> stringHashSet = new HashSet<>();
        for (String s : words) {
            StringBuilder morse = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                morse.append(strings[(s.charAt(i) - 'a')]);
            }
            stringHashSet.add(morse.toString());
        }
        return stringHashSet.size();
    }

    public static void main(String[] args) {

        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }
}
