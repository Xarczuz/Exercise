package LeetCode_Easy;

public class LeetCode_551_StudentAttendanceRecordI {

    public boolean checkRecord(String s) {
        int absent = 0;
        int late = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                absent++;
                if (absent > 1) {
                    return false;
                }
            } else if (c == 'L') {
                if (late == 2) {
                    return false;
                }
                late++;
                continue;
            }
            late = 0;
        }
        return true;
    }
}
