package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_824_GoatLatin {
    public static String toGoatLatin2(String S) {
        StringBuilder sb = new StringBuilder();
        String[] sArray = S.split(" ");
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');
        int index = 1;
        for (String s : sArray) {
            boolean vowel = false;
            char[] charArray = s.toCharArray();
            char constant = '0';
            if (vowelSet.contains(charArray[0])) {
                vowel = true;
                sb.append(charArray[0]);
            } else {
                constant = charArray[0];
            }
            for (int j = 1; j < charArray.length; j++) {
                char c = charArray[j];
                sb.append(c);
            }
            if (!vowel) {
                sb.append(constant);
            }
            appendAs(sb, index);
            index++;
            sb.append(' ');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');
        int index = 1;
        boolean newWord = true;
        boolean vowel = false;
        char constant = '0';
        for (char s : S.toCharArray()) {
            if (s == ' ') {
                newWord = true;
                if (!vowel) {
                    appendConstant(sb, index, constant);
                } else {
                    appendAs(sb, index);
                }
                index++;
                vowel = false;
            }
            if (newWord && vowelSet.contains(s)) {
                vowel = true;
                sb.append(s);
                newWord = false;
                continue;
            } else if (newWord && s != ' ') {
                constant = s;
                vowel = false;
                newWord = false;
                continue;
            }
            sb.append(s);

        }
        if (!vowel) {
            appendConstant(sb, index, constant);
        } else {
            appendAs(sb, index);
        }

        return sb.toString();
    }

    private static void appendAs(StringBuilder sb, int index) {
        sb.append("ma");
        for (int j = 0; j < index; j++) {
            sb.append('a');
        }
    }

    private static void appendConstant(StringBuilder sb, int index, char constant) {
        sb.append(constant);
        appendAs(sb, index);
    }
}
