package LeetCode_Easy;

public class LeetCode_557_ReverseWordsinaStringIII {

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbRes = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(' ');
                sbRes.append(sb);
                sb = new StringBuilder();
            } else {
                sb.insert(0, c);
            }
        }
        sbRes.append(sb);
        return sbRes.toString();
    }

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s1.length - 1; i++) {
            String c = s1[i];
            sb.append(reverseString(c.toCharArray()));
            sb.append(" ");
        }
        String c = s1[s1.length - 1];
        sb.append(reverseString(c.toCharArray()));

        return sb.toString();
    }

    public char[] reverseString(char[] s) {
        int half = s.length / 2;
        for (int i = 0, j = s.length - 1; i < half; i++, j--) {
            char swap = s[i];
            s[i] = s[j];
            s[j] = swap;
        }
        return s;
    }
}
