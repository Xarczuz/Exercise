package LeetCode_Easy;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_929_UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> hashSet = new HashSet<>();
        for (String s : emails) {
            boolean add = true;
            char[] c = s.toCharArray();
            StringBuilder sb = new StringBuilder(c.length);
            int i = 0;
            while (c[i] != '@') {
                if (add && c[i] == '+') {
                    add = false;
                } else if (add && c[i] != '.') {
                    sb.append(c[i]);
                }
                i++;
            }
            sb.append(s.substring(i));
            hashSet.add(sb.toString());
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_929_UniqueEmailAddresses().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
