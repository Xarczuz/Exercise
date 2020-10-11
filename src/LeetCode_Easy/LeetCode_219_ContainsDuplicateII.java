package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashMap;

public class LeetCode_219_ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>(nums.length);
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int n = nums[i];
            if (map.containsKey(n)) {
                ArrayList<Integer> arrayList = map.get(n);
                for (int indexes : arrayList) {
                    if (i - indexes <= k) {
                        return true;
                    }
                }
                arrayList.add(i);
            } else {
                ArrayList<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(n, arr);
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int n = nums[i];
            if (map.containsKey(n) && i - map.get(n) <= k) {
                return true;
            }
            map.put(n, i);

        }
        return false;
    }
}
