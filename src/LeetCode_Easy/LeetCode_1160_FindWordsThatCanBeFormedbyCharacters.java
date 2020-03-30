package LeetCode_Easy;

public class LeetCode_1160_FindWordsThatCanBeFormedbyCharacters {

    public static void main(String[] args) {
        String[] words = new String[]{"cat", "bt", "hat", "tree"};
    }

    public int countCharacters(String[] words, String chars) {
        char[] charsArr = new char[26];
        for (char c : chars.toCharArray()) {
            charsArr[c - 97]++;
        }

        int sum = 0;
        for (String s : words) {
            char[] charsArrClone = charsArr.clone();
            boolean add = true;
            for (char c : s.toCharArray()) {
                if (charsArrClone[c - 97] > 0) {
                    charsArrClone[c - 97]--;
                } else {
                    add = false;
                    break;
                }
            }
            if (add) {
                sum += s.length();
            }
        }
        return sum;
    }

}
