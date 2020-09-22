package LeetCode_Easy;

import java.util.LinkedList;
import java.util.List;

public class LeetCode_989_AddtoArrayFormofInteger {

    public static List<Integer> addToArrayForm(int[] A, int K) {

        int indexA = A.length - 1;
        String B = String.valueOf(K);
        int indexB = B.length() - 1;
        LinkedList<Integer> integers = new LinkedList<>();
        int carry = 0;
        while (indexA >= 0 || indexB >= 0) {
            int n1 = 0;
            int n2 = 0;
            if (indexA >= 0) {
                n1 = A[indexA];
                indexA--;
            }
            if (indexB >= 0) {
                n2 = K % 10;
                K /= 10;
                indexB--;
            }

            int sum = carry + n1 + n2;
            int rest = sum % 10;
            carry = sum / 10;
            integers.addFirst(rest);
        }

        if (carry > 0) {
            integers.addFirst(carry);
        }
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{4, 4}, 66));
    }
}
