package LeetCode_Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class LeetCode_819_MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        bannedSet.add("");
        HashMap<String, Integer> wordMapper = new HashMap<>();
        StringBuilder st = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                st.append(c);
            } else if (c >= 'A' && c <= 'Z') {
                st.append((char) (c + 32));
            } else if (st.length() != 0) {
                wordMapper.put(st.toString(), wordMapper.getOrDefault(st.toString(), 0) + 1);
                st = new StringBuilder();
            }
        }
        wordMapper.put(st.toString(), wordMapper.getOrDefault(st.toString(), 0) + 1);
        int max = 0;
        String mostCommon = "";
        for (Map.Entry<String, Integer> set : wordMapper.entrySet()) {
            if (set.getValue() > max && !bannedSet.contains(set.getKey())) {
                mostCommon = set.getKey();
                max = set.getValue();
            }
        }
        return mostCommon;
    }
}
