package LeetCode_Easy;

import java.util.HashSet;

public class LeetCode_659_BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() == 0 || B.length() == 0
                || A.length() != B.length()) {
            return false;
        }

        if (A.equals(B) && !noTwoLetterThatAreSameInA(A)) {
            return false;
        }
        return areAllCharsTheSame(A.toCharArray(), B.toCharArray());
    }

    private boolean areAllCharsTheSame(char[] a, char[] b) {
        char[] zeroSum = new char[27];
        int diff = 0;
        for (int i = 0; i < a.length; i++) {
            zeroSum[a[i] - 97]++;
            zeroSum[b[i] - 97]--;
            if (a[i] != b[i]) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }

        for (int i : zeroSum) {
            if (i > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean noTwoLetterThatAreSameInA(String a) {
        HashSet<Character> hashSet = new HashSet<>();
        for (char c : a.toCharArray()) {
            if (hashSet.contains(c)) {
                return true;
            } else {
                hashSet.add(c);
            }
        }
        return false;
    }

}
