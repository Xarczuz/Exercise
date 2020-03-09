package LeetCode_Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode_811_SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> visitedSites = new HashMap<>();
        for (String s : cpdomains) {
            splitter2(s, visitedSites);
        }
        List<String> arr = new ArrayList<>(visitedSites.size());
        visitedSites.forEach((s, integer) -> {
            arr.add(new StringBuilder().append(integer).append(" ").append(s).toString());
        });
        return arr;
    }

    public static void splitter(String s, HashMap<String, Integer> visitedSites) {
        int visited = 0;
        int dots = 0;
        int i = 0;
        while (s.charAt(i) != ' ') {
            visited = visited * 10 + s.charAt(i) - '0';
            i++;
        }
        String link = s.substring(i + 1);
        visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
        for (; i < s.length(); i++) {
            if (s.charAt(i) == '.') {
                link = s.substring(i + 1);
                visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
                dots++;
                if (dots == 2) {
                    break;
                }
            }
        }
    }

    public static void splitter2(String s, HashMap<String, Integer> visitedSites) {
        int visited = 0;
        int i = 0;
        while (s.charAt(i) != ' ') {
            visited = visited * 10 + s.charAt(i) - '0';
            i++;
        }
        String link = s.substring(i + 1);
        visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
        int index = link.indexOf('.');
        while (index != -1) {
            link = link.substring(index + 1);
            visitedSites.put(link, visitedSites.getOrDefault(link, 0) + visited);
            index = link.indexOf('.');
        }
    }

    private static int parseInt(String s, int visited) {
        int g = 0;
        while (g < s.length() && s.charAt(g) != ' ') {
            visited = visited * 10 + s.charAt(g) - '0';
            g++;
        }
        return visited;
    }

    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"9001 discuss.leetcode.com"}));
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
}
