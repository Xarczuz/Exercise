package LeetCode_Easy;

public class LeetCode_925_LongPressedName {

    public boolean isLongPressedName(String name, String typed) {

        int i = 0;
        char[] charArray = name.toCharArray();
        char prevC = ' ';
        for (char c : charArray) {
            boolean found = false;
            for (; i < typed.length(); i++) {
                if (typed.charAt(i) == c) {
                    i++;
                    found = true;
                    break;
                } else if (typed.charAt(i) != prevC) {
                    return false;
                }
            }
            if (!found) {
                return false;
            }
            prevC = c;
        }

        for (; i < typed.length(); i++) {
            if (typed.charAt(i) != charArray[charArray.length - 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isLongPressedName2(String name, String typed) {
        int i = 0, m = name.length(), n = typed.length();
        for (int j = 0; j < n; ++j)
            if (i < m && name.charAt(i) == typed.charAt(j))
                ++i;
            else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1))
                return false;
        return i == m;
    }
}
