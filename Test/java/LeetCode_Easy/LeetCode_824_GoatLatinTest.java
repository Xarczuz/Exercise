package LeetCode_Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode_824_GoatLatinTest {
    @Test
    void test() {
        assertEquals(LeetCode_824_GoatLatin.toGoatLatin("I speak Goat Latin"), "Imaa peaksmaaa oatGmaaaa atinLmaaaaa");
    }

    @Test
    void test2() {
        assertEquals(LeetCode_824_GoatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog"), "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa");
    }
}