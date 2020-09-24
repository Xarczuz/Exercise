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

    public static boolean hasAlternatingBits2(int n) {
        String binary = Integer.toBinaryString(n);
        System.out.println(binary);
        int d = n & 1;
        for (int i = 1; i <= binary.length(); i++) {
            int c = (n >> i) & 1;
            System.out.println(c + " " + d);
            if (d == c) {
                return false;
            }
            d = c;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits2(5));
    }
}
