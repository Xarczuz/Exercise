package LeetCode_Easy;

import java.util.HashMap;
import java.util.Objects;

public class LeetCode_1128_NumberofEquivalentDominoPairs {
    public int numEquivDominoPairs2(int[][] dominoes) {
        int[][] ints = new int[10][10];
        int x, y;
        for (int[] d : dominoes) {
            if (d[0] < d[1]) {
                x = d[0];
                y = d[1];
            } else {
                x = d[1];
                y = d[0];
            }
            ints[x][y]++;
        }
        int pairs = 0;
        for (int[] i : ints) {
            for (int n : i) {
                pairs += (n * (n - 1)) / 2;
            }
        }
        return pairs;
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Pair, Integer> pairsMap = new HashMap<>();
        for (int[] d : dominoes) {
            int x, y;
            if (d[0] < d[1]) {
                x = d[0];
                y = d[1];
            } else {
                x = d[1];
                y = d[0];
            }
            Pair p = new Pair(x, y);
            pairsMap.put(p, pairsMap.getOrDefault(p, 0) + 1);
        }
        int pairs = 0;
        for (int n : pairsMap.values()) {
            pairs += (n * (n - 1)) / 2;
        }
        return pairs;
    }

    private static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x &&
                    y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

