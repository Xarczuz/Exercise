package LeetCode_Easy;

public class LeetCode_461_HammingDistance {
    public static int hammingDistance(int x, int y) {
        String s1 = Integer.toBinaryString(x);
        String s2 = Integer.toBinaryString(y);
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int index = Math.abs(i - j);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < index; k++) {
            sb.append("0");
        }
        if (i > j) {
            sb.append(s2);
            s2 = sb.toString();
        } else {
            sb.append(s1);
            s1 = sb.toString();
        }
        int dist = 0;
        index = 0;
        while (index < s1.length()) {
            if (s1.charAt(index) != s2.charAt(index)) {
                dist++;
            }
            index++;
        }
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(2, 9));
        System.out.println(hammingDistance(0, 500));
        System.out.println(hammingDistance(654, 9999));
    }
}
