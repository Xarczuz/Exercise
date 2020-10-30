package LeetCode_Easy;

public class LeetCode_551_StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int absent = 0;
        char prevRecA = ' ';
        char prevRecB = ' ';

        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
                if (absent > 1) {
                    return false;
                }
            } else if (c == 'L' && prevRecA == 'L'&& prevRecB == 'L') {
                return false;
            }
            prevRecB = prevRecA;
            prevRecA = c;
        }
        return true;
    }
}
