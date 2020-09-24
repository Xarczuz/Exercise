package LeetCode_Easy;

public class LeetCode_868_Binary_Gap {

    public static int binaryGap(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        boolean startCount = false;
        int max = 0;
        int counter = 0;
        for (char c : binary.toCharArray()) {
            if (c == '1') {
                startCount = true;
                max = Math.max(max, counter);
                counter = 0;
            }
            if (startCount) {
                counter++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(binaryGap(646));//5
    }

}
