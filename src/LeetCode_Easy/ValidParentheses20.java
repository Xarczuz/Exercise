package LeetCode_Easy;

import java.util.Stack;

public class ValidParentheses20 {
    public boolean isValid(String s) {
        if (s.length() == 1) {
            return false;
        }
        Stack<Character> chars = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    chars.push('(');
                    break;
                case '{':
                    chars.push('{');
                    break;
                case '[':
                    chars.push('[');
                    break;
                case ')':
                    if (chars.isEmpty()) {
                        return false;
                    }
                    if (chars.pop() != '(') {
                        return false;
                    }
                    break;
                case '}':
                    if (chars.isEmpty()) {
                        return false;
                    }
                    if (chars.pop() != '{') {
                        return false;
                    }
                    break;
                case ']':
                    if (chars.isEmpty()) {
                        return false;
                    }
                    if (chars.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        return chars.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new ValidParentheses20().isValid("){"));
        System.out.println(new ValidParentheses20().isValid("()[]{}"));
        System.out.println(new ValidParentheses20().isValid("(]"));
        System.out.println(new ValidParentheses20().isValid("{[]}"));
        System.out.println(new ValidParentheses20().isValid("[])"));
    }
}
