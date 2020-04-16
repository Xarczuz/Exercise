package LeetCode_Easy;

public class LeetCode_796_RotateString {
    public static void main(String[] args) {
        new LeetCode_796_RotateString().rotateString("cdeab", "deabc");
    }

    public boolean rotateString(String A, String B) {
        if (A.equals("") && B.equals("")) {
            return true;
        }
        String rotatedA = A;
        for (int i = 0; i < A.length(); i++) {
            if (rotatedA.equals(B)) {
                return true;
            }
            rotatedA = rotateOnce(rotatedA);
        }
        return false;
    }

    private String rotateOnce(String a) {
        return new StringBuilder().append(a, 1, a.length()).append(a, 0, 1).toString();
    }

}
