package LeetCode_Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_890_FindandReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> resArr = new ArrayList<>();
        String nrPattern = patternMaker(pattern);
        for (String w : words) {
            if (havePattern(nrPattern, patternMaker(w))) {
                resArr.add(w);
            }
        }
        return resArr;
    }

    private boolean havePattern(String nrPattern, String w) {
        if (nrPattern.length() < w.length()) {
            for (int i = 0; i < nrPattern.length(); i++) {
                if (nrPattern.charAt(i) != w.charAt(i)) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < w.length(); i++) {
                if (nrPattern.charAt(i) != w.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private String patternMaker(String pattern) {
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

}
