package LeetCode_Easy;

public class LeetCode_1346_CheckIfNandItsDoubleExist {

    public boolean checkIfExist(int[] arr) {

        int[] ints = new int[6001];
        for (int i : arr) {
            ints[i + 3000]++;
        }
        for (int i : arr) {
            if (ints[i * 2 + 3000] >= 1) {
                if (i == 0 && ints[3000] == 1) {
                    continue;
                }
                return true;
            }
        }

        return false;
    }

}
