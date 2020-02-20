package LeetCode_Easy;

public class JewelsandStones771 {
    public static int numJewelsInStones(String J, String S) {
        int stonesThatAreJewels = 0;
        for (char jewel : J.toCharArray()) {
            for (char stone : S.toCharArray()) {
                if (jewel == stone) {
                    stonesThatAreJewels++;
                }
            }
        }
        return stonesThatAreJewels;
    }

    public static int numJewelsInStones2(String J, String S) {
        int[] hash = new int[256];
        for (int i = 0; i < S.length(); i++) {
            hash[S.charAt(i)]++;
        }
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            count += hash[J.charAt(i)];
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(numJewelsInStones2("aA", "aAAbbbb"));
    }
}
