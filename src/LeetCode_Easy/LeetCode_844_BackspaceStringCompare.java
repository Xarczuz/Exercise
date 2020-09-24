package LeetCode_Easy;

public class LeetCode_844_BackspaceStringCompare {
    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("bxj##tw", "bxj###tw"));
        System.out.println(backspaceCompare("bbbextm", "bbb#extm"));
        System.out.println(backspaceCompare("nzp#o#g", "b#nzp#o#g"));
        System.out.println(backspaceCompare("rjhbpvh", "rm#jhbpvh"));
        System.out.println(backspaceCompare("rheyggodcclgstf", "#rheyggodcclgstf"));
        System.out.println(backspaceCompare("abcd", "bbcd"));
    }

    public static boolean backspaceCompare(String S, String T) {
        int indexS = S.length() - 1;
        int indexT = T.length() - 1;
        char s = S.charAt(indexS);
        char t = T.charAt(indexT);
        int wordLengthS = 0;
        int wordLengthT = 0;
        while (indexS >= 0 || indexT >= 0) {
            if (indexS >= 0) {
                indexS = removeBackspace(S, indexS);
                if (indexS > -1) {
                    s = S.charAt(indexS);
                    if (s != '#') {
                        wordLengthS++;
                        indexS--;
                    } else {
                        indexS--;
                        continue;
                    }
                }
            }
            if (indexT >= 0) {
                indexT = removeBackspace(T, indexT);
                if (indexT > -1) {
                    t = T.charAt(indexT);
                    if (t != '#') {
                        wordLengthT++;
                        indexT--;
                    } else {
                        indexT--;
                        continue;
                    }
                }
            }
            if (indexS == -2 && indexT == -2) {
                return wordLengthT == wordLengthS;
            }
            System.out.println(s + " " + t);
            if (s != t) {
                return false;
            }
        }
        return wordLengthT == wordLengthS;
    }

    private static int removeBackspace(String s, int indexS) {
        int backspace = 0;
        if (indexS == 0) {
            return 0;
        }
        while (indexS >= 0 && (s.charAt(indexS) == '#' || backspace != 0)) {
            if (s.charAt(indexS) == '#') {
                backspace++;
                indexS--;
                continue;
            }
            if (backspace > 0) {
                backspace--;
                indexS--;
            }
        }
        return indexS;
    }
}
