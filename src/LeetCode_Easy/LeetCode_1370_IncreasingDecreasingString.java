package LeetCode_Easy;

public class LeetCode_1370_IncreasingDecreasingString {

    public static void main(String[] args) {
        System.out.println(new LeetCode_1370_IncreasingDecreasingString().sortString2("aaaabbbbcccc"));
        System.out.println(new LeetCode_1370_IncreasingDecreasingString().sortString2("rat"));
        System.out.println(new LeetCode_1370_IncreasingDecreasingString().sortString2("leetcode"));
        System.out.println(new LeetCode_1370_IncreasingDecreasingString().sortString2("ggggggg"));
        System.out.println(new LeetCode_1370_IncreasingDecreasingString().sortString2("spo"));
    }

    public String sortString2(String s) {
        if (s.length() == 0) {
            return "";
        }
        int[] arr = new int[255];
        for (char c : s.toCharArray()) {
            arr[c]++;
        }
        StringBuilder sb = new StringBuilder();
        boolean isArrayEmpty = false;
        while (!isArrayEmpty) {
            isArrayEmpty = true;
            int prev = 0;
            for (int i = 0; i < arr.length; i++) {
                if (i > prev && arr[i] > 0) {
                    sb.append((char) i);
                    arr[i]--;
                    prev = i;
                }
                if (arr[i] > 0) {
                    isArrayEmpty = false;
                }
            }
            prev = Integer.MAX_VALUE;
            for (int i = arr.length - 1; i > 0; i--) {
                if (i < prev && arr[i] > 0) {
                    sb.append((char) i);
                    arr[i]--;
                    prev = i;
                }
                if (arr[i] > 0) {
                    isArrayEmpty = false;
                }
            }

        }

        return sb.toString();
    }

}
