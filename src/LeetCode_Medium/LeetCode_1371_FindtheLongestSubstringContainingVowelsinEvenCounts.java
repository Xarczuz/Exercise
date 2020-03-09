package LeetCode_Medium;

import java.util.HashMap;

public class LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts {
    public static void main(String[] args) {
//        System.out.println(new FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("ebcoebcebc"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("bcbcbc"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("leetcodeisgreat"));
    }

    public int findTheLongestSubstring(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int chunkSize = chars.length;
        while (chunkSize > 0) {
            for (int i = 0; i + chunkSize <= chars.length; i++) {
                if (substringWovels(chars, i, i + chunkSize - 1)) {
                    return chunkSize;
                }
            }
            chunkSize--;
        }

        return res;
    }

    private boolean substringWovels(char[] chars, int i, int j) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('a', 0);
        hashMap.put('e', 0);
        hashMap.put('i', 0);
        hashMap.put('o', 0);
        hashMap.put('u', 0);
        for (; i <= j; i++) {
            switch (chars[i]) {
                case 'a':
                    if (hashMap.get('a') == 1) {
                        hashMap.put('a', 0);
                    } else {
                        hashMap.put('a', 1);
                    }
                    break;
                case 'e':
                    if (hashMap.get('e') == 1) {
                        hashMap.put('e', 0);
                    } else {
                        hashMap.put('e', 1);
                    }
                    break;
                case 'i':
                    if (hashMap.get('i') == 1) {
                        hashMap.put('i', 0);
                    } else {
                        hashMap.put('i', 1);
                    }
                    break;
                case 'o':
                    if (hashMap.get('o') == 1) {
                        hashMap.put('o', 0);
                    } else {
                        hashMap.put('o', 1);
                    }
                    break;
                case 'u':
                    if (hashMap.get('u') == 1) {
                        hashMap.put('u', 0);
                    } else {
                        hashMap.put('u', 1);
                    }
                    break;
            }
        }
        for (int g : hashMap.values()) {
            if (g != 0) {
                return false;
            }
        }
        return true;
    }

}
