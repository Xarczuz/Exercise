package LeetCode_Easy;

public class LeetCode_66_PlusOne {
    public int[] plusOne(int[] digits) {
        int[] newArray = null;
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 10) {
                digits[i] = 0;
                if (i - 1 >= 0) {
                    digits[i - 1]++;
                } else {
                    newArray = new int[digits.length + 1];
                    break;
                }
            }
        }
        if (newArray != null) {
            newArray[0] = 1;
            for (int i = 1; i < digits.length; i++) {
                newArray[i] = digits[i];
            }
            return newArray;
        }
        return digits;
    }
}
