package LeetCode_Easy;

public class LeetCode_1323_Maximum69Number {
    public static int maximum69Number(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(num);
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.substring(i, i + 1).equals("6")) {
                stringBuilder.replace(i, i + 1, "9");
                return Integer.parseInt(stringBuilder.toString());
            }
        }
        return num;
    }

    public static int maximum69Number2(int num) {
        String nr = String.valueOf(num);
        char[] chars = nr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 54) {
                chars[i] = 57;
                return Integer.parseInt(String.valueOf(chars));
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(maximum69Number2(9696));
    }
}
