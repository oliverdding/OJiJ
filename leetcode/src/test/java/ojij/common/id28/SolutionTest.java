package ojij.common.id28;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void strStr() {
        assertEquals("aaabaaacd".indexOf("aaac"), solution.strStr("aaabaaacd", "aaac"));
        assertEquals("sagasdhasdhas".indexOf("sag"), solution.strStr("sagasdhasdhas", "sag"));
        assertEquals("".indexOf("aaac"), solution.strStr("", "aaac"));
        assertEquals("aaabaaacd".indexOf(""), solution.strStr("aaabaaacd", ""));

    }
}