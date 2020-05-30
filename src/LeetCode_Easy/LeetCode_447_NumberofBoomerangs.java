package LeetCode_Easy;

import java.util.HashMap;

public class LeetCode_447_NumberofBoomerangs {

    public static void main(String[] args) {
        System.out.println(new LeetCode_447_NumberofBoomerangs().numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{2, 0}, new int[]{3, 0}, new int[]{4, 0}, new int[]{5, 4}, new int[]{1, 4}, new int[]{5, 6}}));
        System.out.println(new LeetCode_447_NumberofBoomerangs().numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}}));
        System.out.println(new LeetCode_447_NumberofBoomerangs().numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0}}));

    }

    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        int length = points.length;
        HashMap<Double, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (i == j) {
                    continue;
                }

                double dist = distance(points[i], points[j]);
                hashMap.put(dist, hashMap.getOrDefault(dist, 0) + 1);

            }
            for (int val : hashMap.values()) {
                sum += val * (val - 1);
            }
            hashMap.clear();

        }

        return sum;
    }

    private double distance(int[] point, int[] point1) {
        return Math.sqrt(Math.pow(point[0] - point1[0], 2) + Math.pow(point[1] - point1[1], 2));
    }

}
