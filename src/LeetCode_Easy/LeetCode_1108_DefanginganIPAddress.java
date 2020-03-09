package LeetCode_Easy;

public class LeetCode_1108_DefanginganIPAddress {

    public static String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }

    public static String defangIPaddr2(String address) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : address.toCharArray()
        ) {
            if (c == 46) {
                stringBuilder.append("[.]");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.2.1"));
        char[] c = ".".toCharArray();
        System.out.println(c[0]);
    }
}
