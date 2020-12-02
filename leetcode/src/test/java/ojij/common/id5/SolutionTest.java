package ojij.common.id5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();
    @Test
    void longestPalindrome() {
        assertEquals(solution.longestPalindrome("babad"), "bab");
        assertEquals(solution.longestPalindrome("cbbd"), "bb");
    }
}