package LeetCode_Easy;

public class LeetCode_1337_TheKWeakestRowsinaMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] counter = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                counter[i][mat[i][j]]++;
            }
        }

        int[] arr = new int[k];
        int idx = 0;
        int soldiers = 0;
        while (idx != k) {
            for (int i = 0; i < counter.length; i++) {
                if (counter[i][1] == soldiers) {
                    arr[idx] = i;
                    idx++;
                    if (idx == k) {
                        break;
                    }
                }
            }
            soldiers++;
        }
        return arr;
    }
}
