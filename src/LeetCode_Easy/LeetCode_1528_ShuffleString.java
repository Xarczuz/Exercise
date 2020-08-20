package LeetCode_Easy;

public class LeetCode_1528_ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        int size = indices.length;
        char[] newChars = new char[size];
        for (int i = 0; i < size; i++) {
            newChars[indices[i]] = chars[i];
        }
        return new String(newChars);
    }
}
