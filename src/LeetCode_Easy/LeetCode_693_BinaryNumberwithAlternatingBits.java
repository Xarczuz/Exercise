package LeetCode_Easy;

public class LeetCode_693_BinaryNumberwithAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        String binary = Integer.toBinaryString(n);
        char[] bit = binary.toCharArray();
        System.out.println(binary);
        int d = bit[0];
        for (int i = 1; i < bit.length; i++) {
            char c = bit[i];
            if (d == c) {
                return false;
            }
            d = c;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(4));

    }
}
