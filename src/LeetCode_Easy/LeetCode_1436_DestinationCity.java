package LeetCode_Easy;

import java.util.HashMap;
import java.util.List;

public class LeetCode_1436_DestinationCity {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (List<String> path : paths) {
            hashMap.put(path.get(0), path.get(1));
        }
        String start = paths.get(0).get(0);
        while (hashMap.containsKey(start)) {
            start = hashMap.get(start);
        }
        return start;
    }
}
