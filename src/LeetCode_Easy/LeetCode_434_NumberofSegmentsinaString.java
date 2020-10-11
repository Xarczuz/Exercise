package LeetCode_Easy;

public class LeetCode_434_NumberofSegmentsinaString {

    public int countSegments(String s) {
        int sentences = 0;
        char prev = ' ';
        for (char c : s.toCharArray()) {
            if (c != ' ' && prev == ' ') {
                sentences++;
            }
            prev = c;
        }

        return sentences;
    }
}
