package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class DecompressRunLengthEncodedList1313 {
    public static int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> ints = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                ints.add(val);
            }
        }
        return ints.stream().mapToInt(integer -> integer).toArray();
    }

    public static int[] decompressRLElist2(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }
        int[] output = new int[size];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                output[index] = val;
                index++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist2(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
