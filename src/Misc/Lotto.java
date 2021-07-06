package Misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {

    public static void main(String[] args) {
        ArrayList<String> ss = new ArrayList<>();
        extracted(ss, 21, "one");
        extracted(ss, 13, "two");
        extracted(ss, 7, "five");
        extracted(ss, 4, "ten");
        extracted(ss, 4, "coinFlip");
        extracted(ss, 1, "crazyTime");
        extracted(ss, 2, "pachinko");
        extracted(ss, 2, "cashhunt");
        ss.stream().unordered().collect(Collectors.toCollection(ArrayList::new));

        HashMap<String, Integer> res = new HashMap<>();
        int arraySize = ss.size();
        double size = 100000000D;
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            int rand = rnd.nextInt(arraySize);
            res.put(ss.get(rand), res.getOrDefault(ss.get(rand), 0) + 1);
        }
        System.out.println("one " + res.get("one") / size);
        System.out.println("two " + res.get("two") / size);
        System.out.println("five " + res.get("five") / size);
        System.out.println("ten " + res.get("ten") / size);
        System.out.println("coinFlip " + res.get("coinFlip") / size);
        System.out.println("crazyTime " + res.get("crazyTime") / size);
        System.out.println("pachinko " + res.get("pachinko") / size);
        System.out.println("cashhunt " + res.get("cashhunt") / size);
    }

    private static void extracted(ArrayList<String> ss, int size, String name) {
        for (int i = 0; i < size; i++) {
            ss.add(name);
        }
    }
}
