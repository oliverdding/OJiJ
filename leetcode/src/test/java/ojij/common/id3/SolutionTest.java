package ojij.common.id3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(solution.lengthOfLongestSubstring("abcabcbb"), 3);
        assertEquals(solution.lengthOfLongestSubstring("bbbbb"), 1);
        assertEquals(solution.lengthOfLongestSubstring("pwwkew"), 3);
        assertEquals(solution.lengthOfLongestSubstring("abcadefg"), 7);
        assertEquals(solution.lengthOfLongestSubstring("abcdefg"), 7);
        assertEquals(solution.lengthOfLongestSubstring(""), 0);
    }
}