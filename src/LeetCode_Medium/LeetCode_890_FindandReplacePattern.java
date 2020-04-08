package LeetCode_Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode_890_FindandReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resArr = new ArrayList<>();
        int[] nrPattern = patternMaker(pattern);
        for (String w : words) {
            if (havePattern(nrPattern, patternMaker(w))) {
                resArr.add(w);
            }
        }
        return resArr;
    }

    private boolean havePattern(int[] nrPattern, int[] w) {
        for (int i = 0; i < nrPattern.length; i++) {
            if (nrPattern[i] != w[i]) {
                return false;
            }
        }
        return true;
    }

    private int[] patternMaker(String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
        int nr = 0;
        int[] nrPattern = new int[pattern.length()];
        char prev = 0;
        char[] charArray = pattern.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (map.containsKey(c)) {
                nrPattern[i] = map.get(c);
            } else if (c != prev) {
                nr++;
                nrPattern[i] = nr;
                map.put(c, nr);
            } else {
                nrPattern[i] = nr;
            }
            prev = c;
        }
        return nrPattern;
    }

    private String patternMaker2(String pattern) {
        HashMap<Character, Integer> map = new HashMap<>();
        int nr = 0;
        StringBuilder nrPattern = new StringBuilder();
        char prev = 0;
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c)) {
                nrPattern.append(map.get(c));
            } else if (c != prev) {
                nr++;
                nrPattern.append(nr);
                map.put(c, nr);
            } else {
                nrPattern.append(nr);
            }
            prev = c;
        }
        return nrPattern.toString();
    }

    public static void main(String[] args) {
        String s = "abba";
        int[] p = new int[s.length()];
        for (int i = 0; i < p.length; i++) {
            p[i] = s.charAt(i) - 'a';
        }
        System.out.println(Arrays.toString(p));
    }
}
