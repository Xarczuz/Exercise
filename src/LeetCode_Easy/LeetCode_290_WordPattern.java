package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_290_WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String[] strings = splitString(s);
        if (strings.length != pattern.length()) {
            return false;
        }
        int j = 0;
        HashMap<Character, String> map = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            if (map.containsKey(c) && !map.get(c).equals(strings[j]) || !map.containsKey(c) && map.containsValue(strings[j])) {
                return false;
            } else {
                map.put(c, strings[j]);
            }
            j++;
        }
        return true;
    }

    private String[] splitString(String s) {
        char[] chars = s.toCharArray();
        ArrayList<String> strings = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        for (char c : chars) {
            if (c != ' ') {
                st.append(c);
            } else {
                strings.add(st.toString());
                st = new StringBuilder();
            }
        }
        strings.add(st.toString());
        String[] res = new String[strings.size()];
        for (int i = 0; i < strings.size(); i++) {
            res[i] = strings.get(i);
        }
        return res;
    }
}
