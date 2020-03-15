package LeetCode_Easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode_168_ExcelSheetColumnTitleTest {
    LeetCode_168_ExcelSheetColumnTitle leet;

    @BeforeEach
    void setUp() {
        leet = new LeetCode_168_ExcelSheetColumnTitle();
    }

    @Test
    void test1() {
        assertEquals(leet.convertToTitle(1), "A");
    }

    @Test
    void test2() {
        assertEquals(leet.convertToTitle(28), "AB");
    }

    @Test
    void test3() {
        assertEquals(leet.convertToTitle(701), "ZY");
    }

    @Test
    void test4() {
        assertEquals(leet.convertToTitle(52), "AZ");
    }

    @Test
    void test5() {
        assertEquals(leet.convertToTitle(27), "AA");
    }

    @Test
    void test6() {
        assertEquals(leet.convertToTitle(26), "Z");
    }
}