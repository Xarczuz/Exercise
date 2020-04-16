package LeetCode_Easy;

public class LeetCode_860_LemonadeChange {
    public static void main(String[] args) {
        System.out.println(new LeetCode_860_LemonadeChange().lemonadeChange(new int[]{5, 5, 5, 10, 5, 5, 10, 20, 20, 20}));
    }

    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    five++;
                    break;
                case 10:
                    ten++;
                    five--;
                    if (five < 0) {
                        return false;
                    }
                    break;
                case 20:
                    if (five > 0 && ten > 0) {
                        ten--;
                        five--;
                        if (five < 0 || ten < 0) {
                            return false;
                        }
                    } else {
                        five -= 3;
                        if (five < 0) {
                            return false;
                        }
                    }
                    break;
            }
        }
        return true;
    }
}
