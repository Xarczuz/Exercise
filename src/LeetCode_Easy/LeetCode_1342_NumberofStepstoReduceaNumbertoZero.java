package LeetCode_Easy;

public class LeetCode_1342_NumberofStepstoReduceaNumbertoZero {

    public static int numberOfSteps(int num) {
        int counter = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(123));
    }
}
