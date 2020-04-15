package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_1408_StringMatchinginanArray {
    public List<String> stringMatching(String[] words) {
        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }
                if (words[i].contains(words[j])) {
                    hashSet.add(words[j]);
                }
            }
        }
        return new ArrayList<>(hashSet);
    }
}
