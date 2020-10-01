package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_401_BinaryWatch {

    public static List<String> readBinaryWatch(int num) {
        HashSet<String> times = new HashSet<>();
        int[] hourAndMin = new int[]{1, 2, 4, 8, 1, 2, 4, 8, 16, 32}; // index > 3 = min
        List<int[]> combinations = generate(10, num);
        for (int[] combo : combinations) {
            int hour = 0;
            int min = 0;
            for (int i : combo) {
                if (i <= 3) {
                    hour += hourAndMin[i];
                } else {
                    min += hourAndMin[i];
                }
            }
            String time = getTime(hour, min);
            times.add(time);
        }
        times.remove("");
        return new ArrayList<>(times);
    }

    private static String getTime(int hour, int min) {
        StringBuilder st = new StringBuilder();
        if (hour > 11 || min > 59) {
            return "";
        }
        if (min < 10) {
            return st.append(hour).append(":0").append(min).toString();
        }
        return st.append(hour).append(":").append(min).toString();
    }

    public static List<int[]> generate(int n, int r) {
        List<int[]> combinations = new ArrayList<>();
        helper(combinations, new int[r], 0, n - 1, 0);
        return combinations;
    }

    private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
        if (index == data.length) {
            int[] combination = data.clone();
            combinations.add(combination);
        } else if (start <= end) {
            data[index] = start;
            helper(combinations, data, start + 1, end, index + 1);
            helper(combinations, data, start + 1, end, index);
        }
    }

    public static void main(String[] args) {
        System.out.println(readBinaryWatch(0));

    }

    //With back tracing from https://leetcode.com/problems/binary-watch/discuss/88451/0ms-C%2B%2B-Back-tracking-Solution-with-explanation
    public List<String> readBinaryWatch2(int num) {
        List<String> s = new ArrayList<>();
        if (num == 0) {
            s.add("0:00");
            return s;
        }
        times(s, num, 0, 0, 0);
        return s;
    }

    int[] hourVals = {1, 2, 4, 8};
    int[] minuteVals = {1, 2, 4, 8, 16, 32};

    void times(List<String> res, int num, int hour, int min, int startPoint) {
        if (num == 0) {
            res.add((hour + (min < 10 ? ":0" : ":") + min));
        }

        for (int i = startPoint; i < hourVals.length + minuteVals.length; i++) {
            if (i < hourVals.length) {
                if (hour + hourVals[i] < 12) times(res, num - 1, hour + hourVals[i], min, i + 1);
            } else {
                if (min + minuteVals[i - hourVals.length] < 60)
                    times(res, num - 1, hour, min + minuteVals[i - hourVals.length], i + 1);
            }

        }
    }
}
