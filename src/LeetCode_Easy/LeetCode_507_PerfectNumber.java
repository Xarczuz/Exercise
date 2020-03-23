package LeetCode_Easy;

public class LeetCode_507_PerfectNumber {
    public static void main(String[] args) {
        System.out.println(new LeetCode_507_PerfectNumber().checkPerfectNumber(28));
    }

    public boolean checkPerfectNumber(int num) {
        if (num % 2 != 0) {
            return false;
        }
        int half = (int) Math.sqrt(num);
        int sum = 1;
        for (int i = 2; i <= half; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
}
