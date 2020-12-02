package ojij.common.id5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void longestPalindrome() {
        Solution solution = new Solution();
        assertEquals(solution.longestPalindrome("babad"), "bab");
        assertEquals(solution.longestPalindrome("cbbd"), "bb");
    }
}