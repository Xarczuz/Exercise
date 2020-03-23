package LeetCode_Easy;

public class LeetCode_557_ReverseWordsinaStringIII {

    public static void main(String[] args) {
        System.out.println(new LeetCode_557_ReverseWordsinaStringIII().reverseWords3("leet code code"));
    }

    public String reverseWords3(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == ' ') {
                end = i - 1;
                reverseString(c, start, end);
                start = i + 1;
            }
        }
        reverseString(c, start, c.length - 1);
        return new String(c);
    }

    private void reverseString(char[] s, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char swap = s[i];
            s[i] = s[j];
            s[j] = swap;
        }
    }

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
