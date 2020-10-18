package LeetCode_Easy;

public class LeetCode_1592_RearrangeSpacesBetweenWords {

    public String reorderSpaces(String text) {
        char[] chars = text.toCharArray();
        int spaces = 0, words = 0;
        boolean word = false;
        for (char c : chars) {
            if (c == ' ') {
                spaces++;
                word = false;
            } else if (!word) {
                word = true;
                words++;
            }
        }
        StringBuilder st = new StringBuilder();
        if (words == 1) {
            return oneWord(chars, spaces, st);
        } else {
            return moreWords(chars, spaces, words, st);
        }
    }

    private String moreWords(char[] chars, int spaces, int words, StringBuilder st) {
        int spaceNeeded = spaces / (words - 1);
        int spaceOver = spaces % (words - 1);
        words--;
        boolean appendSpace = false;
        for (char c : chars) {
            if (c != ' ') {
                st.append(c);
                appendSpace = true;
            } else if (appendSpace && words != 0) {
                st.append(addSpace(spaceNeeded));
                appendSpace = false;
                words--;
            }
        }
        st.append(addSpace(spaceOver));
        return st.toString();
    }

    private String oneWord(char[] chars, int spaces, StringBuilder st) {
        for (char c : chars) {
            if (c != ' ') {
                st.append(c);
            }
        }
        st.append(addSpace(spaces));
        return st.toString();
    }

    private String addSpace(int spaceNeeded) {
        StringBuilder st = new StringBuilder();
        for (int i = 0; i < spaceNeeded; i++) {
            st.append(" ");
        }
        return st.toString();
    }
}
