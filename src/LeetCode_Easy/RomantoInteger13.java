package LeetCode_Easy;

public class RomantoInteger13 {

    public int romanToInt(String s) {
        int sum = 0;
        int current = 0;
        int prev = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            current = charToint(chars[i]);
            if (current < prev) {
                sum -= current;
            } else {
                sum += current;
            }
            prev = current;
        }
        return sum;
    }

    public int charToint(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }
}
