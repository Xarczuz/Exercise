package LeetCode_Easy;

public class LeetCode_58_LengthofLastWord {
    public int lengthOfLastWord(String s) {
        int counter = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (counter == 0) {
                    continue;
                }
                return counter;
            } else {

                counter++;
            }
        }
        return counter;
    }
}
