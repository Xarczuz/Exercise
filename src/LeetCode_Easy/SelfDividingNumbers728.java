package LeetCode_Easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SelfDividingNumbers728 {
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
        List<Integer> integers = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            boolean self = false;
            int nr = i;
            int rest;
            while (nr != 0) {
                rest = nr % 10;
                nr /= 10;
                if (rest == 0 || i % rest != 0) {
                    self = false;
                    break;
                }
                self = true;
            }
            if (self) {
                integers.add(i);
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers2(1, 22));
        System.out.println(selfDividingNumbers2(10, 25));
        System.out.println(selfDividingNumbers2(500, 612));

    }
}
