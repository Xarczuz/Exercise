package LeetCode_Easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LeetCode_659_BuddyStringsTest {

    LeetCode_659_BuddyStrings buddy;

    @BeforeEach
    void setUp() {
        buddy = new LeetCode_659_BuddyStrings();
    }

    @Test
    void buddyStrings() {
        assertTrue(buddy.buddyStrings("ab", "ba"));
    }

    @Test
    void buddyStrings2() {
        assertFalse(buddy.buddyStrings("ab", "ab"));
    }

    @Test
    void buddyStrings3() {
        assertTrue(buddy.buddyStrings("aa", "aa"));
    }

    @Test
    void buddyStrings4() {
        assertTrue(buddy.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    @Test
    void buddyStrings5() {
        assertFalse(buddy.buddyStrings("", "ab"));
    }

    @Test
    void buddyStrings6() {
        assertFalse(buddy.buddyStrings("kiabcdefg", "abicdefgk"));
    }

    @Test
    void buddyStrings7() {
        assertFalse(buddy.buddyStrings("abcaa", "abcbb"));
    }

}