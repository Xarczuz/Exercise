package LeetCode_Medium;

import java.util.HashMap;

public class LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts {
    public static void main(String[] args) {
//        System.out.println(new FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("ebcoebcebc"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("bcbcbc"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("eleetminicoworoep"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("leetcodeisgreat"));
        System.out.println(new LeetCode_1371_FindtheLongestSubstringContainingVowelsinEvenCounts().findTheLongestSubstring("leetcodeisgreatrree"));

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


/*
Inspired by lee215's solution with some extension to make the solution more easy to understand.

lee 215's solution
https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/discuss/531840/JavaPython-One-Pass
* Same idea, we use a state to encode the vowels information for prefix string end at index i.

1 State has 5 bits, each bits to indicate if the corresponding vowel have even count or not.

2 When current index have a vowel character, we use bitwise xor to toggle the bit value. state ^= (1 << digit);

3 For the substring between two index have identical state, then all vowels's count are even number.

Eg if from 0 - i, we have even number of 'a', and from 0- j, if we have even number of 'a' again, then the substring between i and j will have even number of 'a' as well. This would be the same if 0 - i and 0 - j both have odd number of 'a'.
Suggested by @multics, we are tracking the value that corresponds to the value of the desired bit to flip. In this way, we can avoid bit shifting.
*/

    HashMap<Character, Integer> vowlToBitIndex = new HashMap<Character, Integer>() {
        {
            put('a', 1);
            put('e', 2);
            put('i', 4);
            put('o', 8);
            put('u', 16);
        }
    };

    public int findTheLongestSubstring2(String s) {
        HashMap<Integer, Integer> stateToIndex = new HashMap<>();
        stateToIndex.put(0, -1);
        int state = 0, maxLen = 0;
        for (int i = 0; i < s.length(); ++i) {
            char cur = s.charAt(i);
            if (vowlToBitIndex.containsKey(cur)) {
                // flap the digits of the state. 1-> 0 or 0 -> 1
                int bitToFlip = vowlToBitIndex.get(cur);
                state ^= bitToFlip;
            }

            stateToIndex.putIfAbsent(state, i);
            maxLen = Math.max(maxLen, i - stateToIndex.get(state));
        }

        return maxLen;
    }
}
