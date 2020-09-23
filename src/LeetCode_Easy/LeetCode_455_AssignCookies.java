package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0) {
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChildren = 0;
        int indexG = g.length - 1;
        int indexS = s.length - 1;
        while (indexG >= 0 && indexS >= 0) {
            if (g[indexG] <= s[indexS]) {
                indexG--;
                indexS--;
                contentChildren++;
            } else {
                indexG--;
            }
        }

        return contentChildren;
    }
}
