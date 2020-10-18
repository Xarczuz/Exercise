package LeetCode_Easy;

public class LeetCode_405_ConvertaNumbertoHexadecimal {

    char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        String result = "";
        while (num != 0) {
            result = String.valueOf(map[(num & 15)]).concat(result);
            num = (num >>> 4);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode_405_ConvertaNumbertoHexadecimal().toHex(Integer.MAX_VALUE));
    }
}
