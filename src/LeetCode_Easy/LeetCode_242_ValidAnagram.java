package LeetCode_Easy;

public class LeetCode_242_ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] isAna = new int[26];
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0, length = s.length(); i < length; i++) {
            isAna[chars1[i] - 'a']++;
            isAna[chars2[i] - 'a']--;
        }
        for (int i : isAna) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
