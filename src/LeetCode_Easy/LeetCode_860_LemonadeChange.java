package LeetCode_Easy;

public class LeetCode_860_LemonadeChange {
    public static void main(String[] args) {
        System.out.println(new LeetCode_860_LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                ten++;
                five--;
                if (five < 0) {
                    return false;
                }
            } else {
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;
                }
                if (five < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
