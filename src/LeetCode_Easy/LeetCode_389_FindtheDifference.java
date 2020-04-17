package LeetCode_Easy;

public class LeetCode_389_FindtheDifference {

    public static void main(String[] args) {
        System.out.println(new LeetCode_389_FindtheDifference().findTheDifference2("abcd", "abcde"));
    }

    public char findTheDifference(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int[] ints = new int[27];
        for (int i = 0; i < charsS.length; i++) {
            ints[charsT[i] - 96]++;
            ints[charsS[i] - 96]--;
        }
        ints[charsT[charsS.length] - 96]++;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > 0) {
                return (char) (i + 96);
            }
        }
        return 255;
    }

    public char findTheDifference2(String s, String t) {
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        int sum = 0;
        for (int i = 0; i < charsS.length; i++) {
            sum ^= charsT[i];
            sum ^= charsS[i];
        }
        sum ^= charsT[charsS.length];
        return (char) sum;
    }
}
