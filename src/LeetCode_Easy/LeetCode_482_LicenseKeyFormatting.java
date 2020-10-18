package LeetCode_Easy;

public class LeetCode_482_LicenseKeyFormatting {

    public static String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        StringBuilder st = new StringBuilder();
        int count = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c != '-') {
                if (count == K) {
                    st.append("-");
                    count = 0;
                }
                if (c > 'Z') {
                    st.append((char) (c - 32));
                } else {
                    st.append(c);
                }
                count++;
            }
        }
        return st.reverse().toString();
    }

}
