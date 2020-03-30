package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_500_KeyboardRow {
    public String[] findWords(String[] words) {
        char[] rowOne = new char[26];
        char[] rowTwo = new char[26];
        char[] rowThree = new char[26];
        for (char c : "qwertyuiop".toCharArray()) {
            rowOne[c - 'a']++;
        }
        for (char c : "asdfghjkl".toCharArray()) {
            rowTwo[c - 'a']++;
        }
        for (char c : "zxcvbnm".toCharArray()) {
            rowThree[c - 'a']++;
        }
        List<String> list = new ArrayList<>();
        for (String w : words) {
            boolean add1 = true;
            boolean add2 = true;
            boolean add3 = true;
            char[] s = w.toLowerCase().toCharArray();
            for (char c : s) {
                if (rowOne[c - 'a'] == 0) {
                    add1 = false;
                    break;
                }
            }
            for (char c : s) {
                if (rowTwo[c - 'a'] == 0) {
                    add2 = false;
                    break;
                }
            }
            for (char c : s) {
                if (rowThree[c - 'a'] == 0) {
                    add3 = false;
                    break;
                }
            }
            if (add1 || add2 || add3) {
                list.add(w);
            }
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            res[i] = s;
        }
        return res;
    }
}
