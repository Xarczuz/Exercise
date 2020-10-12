package LeetCode_Easy;

public class LeetCode_1614_MaximumNestingDepthoftheParentheses {
    public int maxDepth(String s) {
        int max = 0;
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                counter++;
            } else if (c == ')') {
                counter--;
            }
            max = Math.max(counter, max);
        }
        return max;
    }
}
