package Misc;

public class CountWordsInString {
    public static void main(String[] args) {

        System.out.println(new CountWordsInString().countWords("  #¤d &#¤&  hej ,.,.sf see ,., ., a  ,.-")); //5words

    }

    public int countWords(String s) {
        boolean insideWord = false;
        int words = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                insideWord = true;
            } else if (insideWord) {
                insideWord = false;
                words++;
            }
        }
        if (insideWord)
            words++;
        return words;
    }
}
