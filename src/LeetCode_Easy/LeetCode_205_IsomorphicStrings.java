package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_205_IsomorphicStrings {

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), t.charAt(i));
            } else if (map.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
        }
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map2.containsKey(t.charAt(i))) {
                map2.put(t.charAt(i), s.charAt(i));
            } else if (map2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }

        StringBuilder st = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            st.append(map.get(s.charAt(i)));
        }
        if (!st.toString().equals(t)) {
            return false;
        }
        StringBuilder st2 = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            st2.append(map2.get(t.charAt(i)));
        }
        return st2.toString().equals(s);
    }

    public static boolean isIsomorphic2(String s, String t) {
        char[] chars1 = new char[256];
        char[] chars2 = new char[256];
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        for (int i = 0; i < charArrayS.length; i++) {
            chars1[charArrayS[i]] = charArrayT[i];
            chars2[charArrayT[i]] = charArrayS[i];
        }
        for (int i = 0; i < charArrayS.length; i++) {
            if (chars1[charArrayS[i]] != charArrayT[i] || chars2[charArrayT[i]] != charArrayS[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
