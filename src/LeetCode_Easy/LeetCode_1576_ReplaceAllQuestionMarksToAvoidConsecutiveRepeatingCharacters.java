package LeetCode_Easy;

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode_1576_ReplaceAllQuestionMarksToAvoidConsecutiveRepeatingCharacters {

    public static String modifyString(String s) {

        char[] chars = s.toCharArray();
        LinkedList<IndexAndChar> indexAndChars = new LinkedList<IndexAndChar>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != '?') {
                indexAndChars.addLast(new IndexAndChar(i, chars[i]));
            }
        }
        if (indexAndChars.size() == 0) {
            int letter = 0;
            for (int i = 0; i < chars.length; i++, letter++) {
                chars[i] = (char) ('a' + letter);
                if (letter > 1) {
                    letter = 0;
                }
            }
            return new String(chars);
        }

        if (indexAndChars.get(0).index != 0) {
            int letter = 0;
            for (int i = 0; i < indexAndChars.get(0).index; i++, letter++) {
                if (i == indexAndChars.get(0).index - 1) {
                    if (chars[i + 1] == (char) ('a' + letter)) {
                        letter++;
                        if ((i - 1) > 0 && chars[i - 1] == (char) ('a' + letter)) {
                            letter++;
                        }
                    }
                }
                chars[i] = (char) ('a' + letter);
                if (letter > 1) {
                    letter = 0;
                }
            }
        }
        if (indexAndChars.get(indexAndChars.size() - 1).index != chars.length - 1) {
            int letter = 0;
            for (int i = indexAndChars.get(indexAndChars.size() - 1).index + 1; i < chars.length; i++, letter++) {
                if ((char) ('a' + letter) != indexAndChars.get(indexAndChars.size() - 1).c) {
                    chars[i] = (char) ('a' + letter);
                } else {
                    chars[i] = (char) ('a' + letter++ + 1);
                }
            }
        }

        IndexAndChar prev = indexAndChars.pop();
        while (!indexAndChars.isEmpty()) {
            IndexAndChar current = indexAndChars.pop();
            int letter = 0;
            if (prev.c == 'a') {
                letter++;
            }
            for (int i = prev.index + 1; i < current.index; i++, letter++) {
                if (i == current.index - 1) {
                    if (chars[i + 1] == (char) ('a' + letter)) {
                        letter++;
                        if (chars[i - 1] == (char) ('a' + letter)) {
                            letter++;
                        }
                    }
                }
                chars[i] = (char) ('a' + letter);
                if (letter > 2) {
                    letter = 0;
                }
            }
            prev = current;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(modifyString("a?ba?b"));
        System.out.println(modifyString("j?qg??b"));
        System.out.println(modifyString("c?a"));
        System.out.println(modifyString("d?a"));
        System.out.println(modifyString("a?a"));
        System.out.println(modifyString("ab?a"));
        System.out.println(modifyString("ab????ba"));
        System.out.println(modifyString("??????bfi????p?k?"));
        System.out.println(modifyString("?a?ub???w?b"));

    }


    private static class IndexAndChar {
        int index;
        char c;

        public IndexAndChar(int index, char c) {
            this.index = index;
            this.c = c;
        }
    }
}
