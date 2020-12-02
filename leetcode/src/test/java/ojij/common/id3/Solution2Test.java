package ojij.common.id3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {
    Solution2 solution = new Solution2();

    @Test
    void longestPalindrome() {

        assertEquals("bab", solution.longestPalindrome("ababd"));
        assertEquals("bb", solution.longestPalindrome("abbc"));
    }

}