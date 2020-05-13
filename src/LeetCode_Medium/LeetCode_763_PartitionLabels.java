package LeetCode_Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LeetCode_763_PartitionLabels {

    public static void main(String[] args) {
        System.out.println(new LeetCode_763_PartitionLabels()
                .partitionLabels("qiejxqfnqceocmy"));
        System.out.println(new LeetCode_763_PartitionLabels()
                .partitionLabels("ababcbacadefegdehijhklijåäöä"));
    }

    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashSet<Character> characters = new HashSet<>();
        char[] chars = S.toCharArray();
        partition(S, 0, chars, characters, arrayList);
        return arrayList;
    }

    public String partition(String S, int highestIndex, char[] chars, HashSet<Character> characters, ArrayList<Integer> arrayList) {
        if (S.length() == 0) {
            return "";
        }
        characters.clear();
        char zero = chars[highestIndex];
        int lastIndexOfZero = S.lastIndexOf(zero);
        int startIndex = highestIndex;
        for (int i = highestIndex; i < lastIndexOfZero; i++) {
            characters.add(chars[i]);
        }
        for (char c : characters) {
            highestIndex = Math.max(S.lastIndexOf(c), highestIndex);
        }
        characters.clear();
        while (highestIndex != lastIndexOfZero) {
            for (int i = lastIndexOfZero; i < highestIndex; i++) {
                characters.add(chars[i]);
            }
            lastIndexOfZero = highestIndex;
            for (char c : characters) {
                highestIndex = Math.max(S.lastIndexOf(c), highestIndex);
            }
        }
        highestIndex++;
        arrayList.add(highestIndex - startIndex);
        if (highestIndex == S.length()) {
            return "";
        }
        return partition(S, highestIndex, chars, characters, arrayList);
    }
}
