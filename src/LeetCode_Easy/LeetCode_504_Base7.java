package LeetCode_Easy;

public class LeetCode_504_Base7 {
    public static String convertToBase7(int num) {
        StringBuilder st = new StringBuilder(10);
        boolean neg = false;
        if (num == 0) {
            st.append("0");
            return st.toString();
        }
        if (num < 0) {
            num *= -1;
            neg = true;
        }
        while (num != 0) {
            st.insert(0, num % 7);
            num /= 7;
        }

        if (neg) {
            st.insert(0, "-");
        }
        return st.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToBase7(-70));
    }
}
