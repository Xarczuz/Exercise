package LeetCode_Easy;

import java.util.Stack;

public class LeetCode_682_BaseballGame {

    public int calPoints(String[] ops) {
        int sum = 0;
        Stack<String> stack = new Stack<>();
        for (String s : ops) {
            switch (s) {
                case "+":
                    String tmp = stack.pop();
                    int add = Integer.parseInt(stack.peek()) + Integer.parseInt(tmp);
                    sum += add;
                    stack.push(tmp);
                    stack.push(String.valueOf(add));
                    break;
                case "D":
                    int doubleValid = Integer.parseInt(stack.peek()) * 2;
                    sum += doubleValid;
                    stack.push(String.valueOf(doubleValid));
                    break;
                case "C":
                    String invalid = stack.pop();
                    sum -= Integer.parseInt(invalid);
                    break;
                default:
                    sum += Integer.parseInt(s);
                    stack.push(s);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_682_BaseballGame().calPoints(new String[]{"5", "2", "C", "D", "+"}));
        System.out.println(new LeetCode_682_BaseballGame().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));

    }
}
