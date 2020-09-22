package LeetCode_Easy;

public class LeetCode_415_AddStrings {

    public static String addStrings(String num1, String num2) {
        StringBuilder st = new StringBuilder();
        char[] nums1char = num1.toCharArray();
        char[] nums2char = num2.toCharArray();
        int carry = 0;
        int num2Index = nums2char.length - 1;
        for (int i = nums1char.length - 1; i >= 0; i--) {
            int n1 = nums1char[i];
            if (num2Index >= 0) {
                int n2 = nums2char[num2Index];
                int sum = n1 + n2 + carry - 96;
                if (sum >= 10) {
                    int rest = sum % 10;
                    carry = 1;
                    st.append(rest);
                } else {
                    carry = 0;
                    st.append(sum);
                }
                num2Index--;
            } else {
                carry = getCarry(st, carry, n1);
            }
        }
        while (num2Index >= 0) {
            int n2 = nums2char[num2Index];
            carry = getCarry(st, carry, n2);
            num2Index--;
        }
        if (carry > 0) {
            st.append(carry);
        }
        return st.reverse().toString();
    }

    private static int getCarry(StringBuilder st, int carry, int n1) {
        int sum = n1 + carry - 48;
        if (sum >= 10) {
            int rest = sum % 10;
            carry = 1;
            st.append(rest);
        } else {
            carry = 0;
            st.append(sum);
        }
        return carry;
    }

    public static void main(String[] args) {

        System.out.println(addStrings("6994", "36"));
    }

}
