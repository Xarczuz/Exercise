package LeetCode;

public class DecryptStringfromAlphabettoIntegerMapping1309 {

    public static String freqAlphabets(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            String s1 = s.substring(i, i + 1);
            if (s1.equals("#")) {
                s1 = s.substring(i - 2, i + 1);
                i -= 2;
            }
            stringBuilder.append(decrypt(s1));
        }
        return stringBuilder.reverse().toString();
    }

    public static String decrypt(String crypt) {
        String s = "";
        switch (crypt) {
            case "1":
                return "a";
            case "2":
                return "b";
            case "3":
                return "c";
            case "4":
                return "d";
            case "5":
                return "e";
            case "6":
                return "f";
            case "7":
                return "g";
            case "8":
                return "h";
            case "9":
                return "i";
            case "10#":
                return "j";
            case "11#":
                return "k";
            case "12#":
                return "l";
            case "13#":
                return "m";
            case "14#":
                return "n";
            case "15#":
                return "o";
            case "16#":
                return "p";
            case "17#":
                return "q";
            case "18#":
                return "r";
            case "19#":
                return "s";
            case "20#":
                return "t";
            case "21#":
                return "u";
            case "22#":
                return "v";
            case "23#":
                return "w";
            case "24#":
                return "x";
            case "25#":
                return "y";
            case "26#":
                return "z";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(freqAlphabets("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }
}
