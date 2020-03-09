package LeetCode_Easy;

public class LeetCode_1281_SubtracttheProductandSumofDigitsofanIntege {
    public static int subtractProductAndSum(int n) {
        String value = String.valueOf(n);
        int product = 1;
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            int product1 = Integer.parseInt(value.substring(i, i + 1));
            product *= product1;
            sum += product1;
        }
        return product - sum;
    }

    public static int subtractProductAndSum2(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int product1 = (n % 10);
            product *= product1;
            sum += product1;
            n = n / 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum2(4421));
    }
}
