package LeetCode_Easy;

import java.util.ArrayList;

public class LeetCode_748_ShortestCompletingWord {
    public static void main(String[] args) {
        System.out.println(new LeetCode_748_ShortestCompletingWord()
                .shortestCompletingWord("TE73696",
                        new String[]{"ten", "two", "better", "talk", "suddenly", "stand", "protect", "collection", "about", "southern"}));
    }

    //Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] chars = licensePlate.toLowerCase().toCharArray();
        ArrayList<Character> characters = new ArrayList<>();
        for (char aChar : chars) {
            if (aChar < 'a') {
                continue;
            }
            characters.add(aChar);
        }
        String closesMatch = "";
        int length = Integer.MAX_VALUE;
        int matchingLetters = 0;
        for (String s : words) {
            char[] word = s.toCharArray();
            int tmpMatchingLetters = 0;
            for (Character character : characters) {
                int k = 0;
                while (k < word.length) {
                    if (word[k] == character) {
                        tmpMatchingLetters++;
                        word[k] = 0;
                        break;
                    }
                    k++;
                }
            }
            if (tmpMatchingLetters > matchingLetters) {
                closesMatch = s;
                matchingLetters = tmpMatchingLetters;
                length = s.length();
            } else if (tmpMatchingLetters == matchingLetters && s.length() < length) {
                closesMatch = s;
                length = s.length();
            }
        }
        return closesMatch;
    }

}
