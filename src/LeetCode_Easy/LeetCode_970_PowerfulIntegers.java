package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_970_PowerfulIntegers {

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < bound; i *= x) {
            for (int j = 1; j < bound; j *= y) {
                int n = i + j;
                if (n <= bound) {
                    if (!list.contains(n))
                        list.add(n);
                }
                if (y == 1)
                    break;
            }
            if (x == 1)
                break;
        }
        return list;
    }
}
