package LeetCode_Easy;

public class RemoveOutermostParentheses1021 {
    public static String removeOuterParentheses(String S) {
        int subStringIndexStart = 0;
        int balance = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                stringBuilder.append(S, subStringIndexStart + 1, i);
                subStringIndexStart = i + 1;
            }
        }
        return stringBuilder.toString();
    }

    public static String removeOuterParentheses2(String S) {
        int balance = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : S.toCharArray()) {
            if (c == '(' && balance++ > 0) {
                stringBuilder.append(c);
            }
            if (c == ')' && --balance > 0) {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses2("(()())(())"));
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses("()()") + ":here");
    }
}