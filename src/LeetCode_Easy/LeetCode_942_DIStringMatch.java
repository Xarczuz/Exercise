package LeetCode_Easy;

import java.util.Arrays;
import java.util.LinkedList;

public class LeetCode_942_DIStringMatch {
    public static int[] diStringMatch(String S) {
        int N = S.length();
        int[] arr = new int[N + 1];
        char[] chars = S.toCharArray();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            linkedList.add(i);
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (chars[i] == 'I') {
                arr[i] = linkedList.removeFirst();
            }
            if (chars[i] == 'D') {
                arr[i] = linkedList.removeLast();
            }
        }
        arr[arr.length - 1] = linkedList.pop();
        return arr;
    }

    public static int[] diStringMatch2(String S) {
        int N = S.length();
        int[] arr = new int[N + 1];
        char[] chars = S.toCharArray();
        int L = 0;
        int R = N;
        for (int i = 0; i < arr.length - 1; i++) {
            if (chars[i] == 'I') {
                arr[i] = L;
                L++;
            }
            if (chars[i] == 'D') {
                arr[i] = R;
                R--;
            }
        }
        arr[arr.length - 1] = R;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch2("IDID")));
        System.out.println(Arrays.toString(diStringMatch2("III")));
        System.out.println(Arrays.toString(diStringMatch2("DDI")));
    }
}
