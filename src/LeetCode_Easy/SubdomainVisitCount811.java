package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount811 {
    static HashMap<String, Integer> visitedSites = new HashMap<>();

    public static List<String> subdomainVisits(String[] cpdomains) {

        for (String s : cpdomains) {
            splitter(s);
        }
        List<String> arr = new ArrayList<>();
        visitedSites.forEach((s, integer) -> {
            StringBuilder sb = new StringBuilder();
            sb.append(integer).append(" ").append(s);
            arr.add(sb.toString());
        });
        return arr;
    }

    public static void splitter(String s) {
        int visited = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                visited = Integer.parseInt(s.substring(0, i));
                String link = s.substring(i + 1);
                visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
            }
            if (s.charAt(i) == '.') {
                String link = s.substring(i + 1);
                visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
    }
}
