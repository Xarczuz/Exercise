package LeetCode_Easy;

import java.util.ArrayList;

public class LeetCode_1389_CreateTargetArrayintheGivenOrder {

    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < index.length; i++) {
            arrayList.add(index[i], nums[i]);
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < arrayList.size(); i++) {
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

}
