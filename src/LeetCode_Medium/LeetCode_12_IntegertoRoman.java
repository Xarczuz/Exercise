package LeetCode_Medium;

public class LeetCode_12_IntegertoRoman {
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if (num - 1000 >= 0) {
                num -= 1000;
                sb.append("M");
            } else if (num - 900 >= 0) {
                num -= 900;
                sb.append("CM");
            } else if (num - 500 >= 0) {
                num -= 500;
                sb.append("D");
            } else if (num - 400 >= 0) {
                num -= 400;
                sb.append("CD");
            } else if (num - 100 >= 0) {
                num -= 100;
                sb.append("C");
            } else if (num - 90 >= 0) {
                num -= 90;
                sb.append("XC");
            } else if (num - 50 >= 0) {
                num -= 50;
                sb.append("L");
            } else if (num - 40 >= 0) {
                num -= 40;
                sb.append("XL");
            } else if (num - 10 >= 0) {
                num -= 10;
                sb.append("X");
            } else if (num - 9 >= 0) {
                num -= 9;
                sb.append("IX");
            } else if (num - 5 >= 0) {
                num -= 5;
                sb.append("V");
            } else if (num - 4 >= 0) {
                num -= 4;
                sb.append("IV");
            } else {
                num -= 1;
                sb.append("I");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_12_IntegertoRoman().intToRoman(2000));
    }
}
