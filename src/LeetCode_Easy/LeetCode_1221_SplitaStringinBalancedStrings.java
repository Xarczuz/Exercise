package LeetCode_Easy;

public class LeetCode_1221_SplitaStringinBalancedStrings {

    public static int balancedStringSplit(String s) {
        int count = 0;
        char[] charArray = s.toCharArray();
        char start = charArray[0];
        int balance = 1;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == start) {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("IOOIIOIO") + " = 4");
        System.out.println(balancedStringSplit("LLLLLLLLLL") + " = 0");
        System.out.println(balancedStringSplit("RLLLLRRRLR") + " = 3");
        System.out.println(balancedStringSplit("RLRRLLRLRL") + " = 4");
        System.out.println(balancedStringSplit("RLLLLRRRLR") + " = 3");
        System.out.println(balancedStringSplit("LLLLRRRR") + " = 1");
        System.out.println(balancedStringSplit("RRLRRLRLLLRL") + " = 2");
    }
}
