package LeetCode_Easy;

public class LeetCode_1450_NumberofStudentsDoingHomeworkataGivenTime {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int doingWork = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                doingWork++;
            }
        }
        return doingWork;
    }
}
