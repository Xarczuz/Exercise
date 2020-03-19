package LeetCode_Easy;

public class LeetCode_67_AddBinary {
    public static String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (a.length() > b.length()) {
            sb.append(b);
            for (int i = 0; i < a.length() - b.length(); i++) {
                sb.insert(0, 0);
            }
            b = sb.toString();
        } else if (b.length() > a.length()) {
            sb.append(a);
            for (int i = 0; i < b.length() - a.length(); i++) {
                sb.insert(0, 0);
            }
            a = sb.toString();
        }
        sb = new StringBuilder();

        boolean carry = false;
        for (int i = a.length() - 1; i >= 0; i--) {
            char aC = a.charAt(i);
            char bC = b.charAt(i);
            if (carry && aC == '1' && bC == '1') {
                sb.insert(0, 1);
            } else if (carry && (aC == '1' || bC == '1')) {
                sb.insert(0, 0);
                carry = true;
            } else if (aC == '1' && bC == '1') {
                sb.insert(0, 0);
                carry = true;
            } else if (aC == '1' || bC == '1') {
                sb.insert(0, 1);
            } else if (carry) {
                sb.insert(0, 1);
                carry = false;
            } else {
                sb.insert(0, 0);
            }
        }
        if (carry) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

}
