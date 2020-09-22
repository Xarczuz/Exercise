package LeetCode_Easy;

public class LeetCode_258_AddDigits {
    public static void main(String[] args) {

        System.out.println(addDigits(888));
    }

    public static int addDigits(int num) {
        //32 16 8 4 2 1
        //   1  0 1 1 0
        String nr = Integer.toString(num);
        while (nr.length() > 1) {
            int newNr = 0;
            for (int i = 0; i < nr.length(); i++) {
                newNr += nr.charAt(i) - 48;
            }
            nr = String.valueOf(newNr);
        }
        return Integer.parseInt(nr);
    }

}
