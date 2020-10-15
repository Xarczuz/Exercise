package LeetCode_Easy;

public class LeetCode_859_BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int ai = -1;
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        int[] letters = new int[26];
        boolean twoLetters = false;
        for (int i = 0, len = A.length(); i < len; i++) {
            if (charsA[i] != charsB[i]) {
                if (ai == -1) {
                    ai = i;
                } else {
                    return swapLetterAtIndex(charsA, charsB, ai, i);
                }
            }
            if (!twoLetters && ++letters[charsA[i] - 'a'] == 2) {
                twoLetters = true;
            }
        }
        if (ai == -1) {
            return twoLetters;
        }
        return false;
    }

    private boolean swapLetterAtIndex(char[] charsA, char[] charsB, int i1, int i2) {
        char temp = charsA[i1];
        charsA[i1] = charsA[i2];
        charsA[i2] = temp;
        if (charsA[i1] != charsB[i1]) {
            return false;
        }
        for (int j = i2, len = charsA.length; j < len; j++) {
            if (charsA[j] != charsB[j]) {
                return false;
            }
        }
        return true;
    }
}
