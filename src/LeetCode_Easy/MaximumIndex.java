package LeetCode_Easy;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MaximumIndex {
    class IndexAndData {
        long value;
        long index;

        public IndexAndData(long value, long index) {
            this.value = value;
            this.index = index;
        }
    }

    public long maxIndex(String size, String s) {
        int length = Integer.parseInt(size);
        String[] array = s.split(" ");
        ArrayList<IndexAndData> arrayListLeft = new ArrayList<>();
        ArrayList<IndexAndData> arrayListRight = new ArrayList<>();
        long maxLeft = Long.MAX_VALUE;
        long maxRight = Long.MIN_VALUE;
        for (int i = 0, j = length - 1; j >= i; ) {
            long left = Long.parseLong(array[i]);
            long right = Long.parseLong(array[j]);
            if (left < maxLeft) {
                arrayListLeft.add(new IndexAndData(left, i));
                maxLeft = left;
            }
            if (right >= maxRight) {
                arrayListRight.add(new IndexAndData(right, j));
                maxRight = right;
            }
            i++;
            j--;
        }
        long maxDistance = Long.MIN_VALUE;
        for (IndexAndData indexAndData : arrayListLeft) {
            for (IndexAndData andData : arrayListRight) {
                if (indexAndData.value <= andData.value) {
                    if ((andData.index - indexAndData.index) >= maxDistance) {
                        maxDistance = andData.index - indexAndData.index;
                    }
                }
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) throws IOException {
        BufferedInputStream scan = new BufferedInputStream((System.in));
        BufferedReader r = new BufferedReader(
                new InputStreamReader(scan, StandardCharsets.UTF_8));
        long T = Long.parseLong(r.readLine());
        MaximumIndex maximumIndex = new MaximumIndex();
        for (long i = 0; i < T; i++) {
            System.out.println(maximumIndex.maxIndex(r.readLine(), r.readLine()));
        }
    }
}
