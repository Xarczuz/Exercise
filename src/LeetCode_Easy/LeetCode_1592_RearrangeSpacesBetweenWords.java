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
            for (char c : chars) {
                if (c != ' ') {
                    st.append(c);
                }
            }
            addSpace(st, spaces);
            return st.toString();
        }

        int spaceNeeded = spaces / (words - 1);
        int spaceOver = spaces % (words - 1);
        words--;
        boolean appendSpace = false;
        for (char c : chars) {
            if (c != ' ') {
                st.append(c);
                appendSpace = true;
            } else if (appendSpace && words != 0) {
                addSpace(st, spaceNeeded);
                appendSpace = false;
                words--;
            }
        }
        addSpace(st, spaceOver);

        return st.toString();
    }

    private void addSpace(StringBuilder st, int spaceNeeded) {
        for (int i = 0; i < spaceNeeded; i++) {
            st.append(" ");
        }
    }
}
