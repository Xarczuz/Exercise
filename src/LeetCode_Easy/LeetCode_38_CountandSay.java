package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_38_CountandSay {

    public String countAndSay(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for (int i = 1; i < n; i++) {
            list = countNext(list);
        }
        StringBuilder sb = new StringBuilder();
        list.forEach(integer -> sb.append(integer));
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
    }
}
