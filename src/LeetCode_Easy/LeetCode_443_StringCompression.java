package LeetCode_Easy;

import java.util.Arrays;

public class LeetCode_443_StringCompression {

    public static void main(String[] args) {
        System.out.println(new LeetCode_443_StringCompression().compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}));
        System.out.println(new LeetCode_443_StringCompression().compress(new char[]{'a'}));
        System.out.println(new LeetCode_443_StringCompression().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(new LeetCode_443_StringCompression().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c', 'c', 'e', 'e'}));
        System.out.println(new LeetCode_443_StringCompression().compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}));
    }

    public int compress(char[] chars) {
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            int count = 0;
            char toCount = chars[i];
            int nextCharPos = i;
            for (; nextCharPos < chars.length; nextCharPos++) {
                if (chars[nextCharPos] == toCount) {
                    count++;
                } else {
                    break;
                }
            }
            chars[index] = toCount;
            if (count > 1 && count < 10) {
                index++;
                chars[index] = (char) (count + 48);
            } else if (count > 9 && count < 100) {
                index++;
                chars[index] = (char) ((count / 10) + 48);
                index++;
                chars[index] = (char) ((count % 10) + 48);
            } else if (count > 99 && count < 1000) {
                index++;
                chars[index] = (char) ((count / 100) + 48);
                index++;
                chars[index] = (char) (((count / 10) % 10) + 48);
                index++;
                chars[index] = (char) ((count % 10) + 48);
            }
            index++;
            i = nextCharPos - 1;
        }
        System.out.println(Arrays.toString(chars));
        return index;
    }
}
