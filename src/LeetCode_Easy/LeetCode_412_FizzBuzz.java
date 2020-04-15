package LeetCode_Easy;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        ArrayList<String> arrayList = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            int fizz = i % 3;
            int buzz = i % 5;
            if (fizz == 0 && buzz == 0) {
                arrayList.add("FizzBuzz");
            } else if (fizz == 0) {
                arrayList.add("Fizz");
            } else if (buzz == 0) {
                arrayList.add("Buzz");
            } else {
                arrayList.add(String.valueOf(i));
            }
        }
        return arrayList;
    }
}
