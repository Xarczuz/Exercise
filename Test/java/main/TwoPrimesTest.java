package java.main;

import LeetCode_Easy.TwoPrimes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoPrimesTest {
    @Test
    void returnTwoPrimesFromEvenNumber() {
        TwoPrimes twoPrimes = new TwoPrimes(10000);

        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(2), "");
        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(4), "2 2");
        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(74), "3 71");
        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(1024), "3 1021");
        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(66), "5 61");
        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(8), "3 5");
        assertEquals(twoPrimes.returnTwoPrimesFromEvenNumber(9990), "17 9973");

    }
}