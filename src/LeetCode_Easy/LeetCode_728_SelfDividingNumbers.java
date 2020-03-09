package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_728_SelfDividingNumbers {
    static boolean init = true;
    static int[] selfDividing = new int[10000];

    public static List<Integer> selfDividingNumbers(int left, int right) {
        if (init) {
            for (int i = 1; i <= 10000; i++) {
                boolean self = false;
                int nr = i;
                int rest;
                while (nr != 0) {
                    rest = nr % 10;
                    nr /= 10;
                    if (rest == 0) {
                        self = false;
                        break;
                    }
                    if (i % rest == 0) {
                        self = true;
                    } else {
                        self = false;
                        break;
                    }
                }
                if (self) {
                    selfDividing[i] = i;
                }
            }
            init = false;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i1 = left; i1 <= right; i1++) {
            int i = selfDividing[i1];
            if (i != 0) {
                integers.add(i);
            }
        }
        return integers;
    }

    public static List<Integer> selfDividingNumbers2(int left, int right) {
        List<Integer> integers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            boolean self = true;
            int nr = i;
            int rest;
            while (nr != 0) {
                rest = nr % 10;
                if (rest == 0 || i % rest != 0) {
                    self = false;
                    break;
                }
                nr /= 10;
            }
            if (self) {
                integers.add(i);
            }
        }
        return integers;
    }

    public static List<Integer> selfDividingNumbers3(int left, int right) {
        List<Integer> integers = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (self(i))
                integers.add(i);
        }
        return integers;
    }

    private static boolean self(int i) {
        int nr = i;
        while (nr != 0) {
            int rest = nr % 10;
            if (rest == 0 || i % rest != 0)
                return false;
            nr /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers3(1, 22));
        System.out.println(selfDividingNumbers3(10, 25));
        System.out.println(selfDividingNumbers3(500, 612));

    }
}
