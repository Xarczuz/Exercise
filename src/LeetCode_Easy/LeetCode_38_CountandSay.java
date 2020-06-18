package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_38_CountandSay {
    HashMap<Integer, String> hashMap = new HashMap<>();
    boolean once = true;

    public String countAndSay(int n) {
        if (once) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            hashMap.put(1, "1");
            int i = 2;
            for (; i <= 30; i++) {
                list = countNext(list);
                StringBuilder sb = new StringBuilder();
                list.forEach(sb::append);
                hashMap.put(i, sb.toString());
            }
            once = false;
        }
        return hashMap.get(n);
    }

    public String countAndSay2(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i < 30; i++) {
            list = countNext(list);
        }

        StringBuilder sb = new StringBuilder();
        list.forEach(sb::append);

        return sb.toString();
    }

    private List<Integer> countNext(List<Integer> list) {
        List<Integer> nextList = new ArrayList<>();

        int counter = 0;
        int prev = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == prev) {
                counter++;
                if (i + 1 == list.size()) {
                    nextList.add(counter);
                    nextList.add(list.get(i));
                }
            } else {
                nextList.add(counter);
                nextList.add(list.get(i - 1));
                counter = 1;
                if (list.size() == i + 1) {
                    nextList.add(1);
                    nextList.add(list.get(i));
                }
            }

            prev = list.get(i);
        }

        return nextList;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("Start");
        System.out.println(new LeetCode_38_CountandSay().countAndSay(1));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(2));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(3));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(4));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(5));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(6));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(7));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(8));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(9));
        System.out.println(new LeetCode_38_CountandSay().countAndSay(10));
        long end = System.currentTimeMillis() - start;
        System.out.println("End: " + end);
        start = System.currentTimeMillis();
        System.out.println("Start2");
        LeetCode_38_CountandSay l38 = new LeetCode_38_CountandSay();
        System.out.println(l38.countAndSay(1));
        System.out.println(l38.countAndSay(2));
        System.out.println(l38.countAndSay(3));
        System.out.println(l38.countAndSay(4));
        System.out.println(l38.countAndSay(5));
        System.out.println(l38.countAndSay(6));
        System.out.println(l38.countAndSay(7));
        System.out.println(l38.countAndSay(8));
        System.out.println(l38.countAndSay(9));
        System.out.println(l38.countAndSay(10));
        end = System.currentTimeMillis() - start;
        System.out.println("End2: " + end);
    }
}
