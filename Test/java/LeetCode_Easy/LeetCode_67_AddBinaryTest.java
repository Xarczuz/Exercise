package LeetCode_Easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LeetCode_67_AddBinaryTest {

    @Test
    void addBinary() {
        assertEquals(LeetCode_67_AddBinary.addBinary("11", "1"), "100");
    }

    @Test
    void addBinary2() {
        assertEquals(LeetCode_67_AddBinary.addBinary("1010", "1011"), "10101");
    }

    @Test
    void addBinary3() {
        assertEquals(LeetCode_67_AddBinary.addBinary("101011", "10101001"), "11010100");
    }

    @Test
    void addBinary4() {
        assertEquals(LeetCode_67_AddBinary.addBinary("0", "0"), "0");
    }

    @Test
    void addBinary5() {
        assertEquals(LeetCode_67_AddBinary.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
                , "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"), "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000");
    }
}