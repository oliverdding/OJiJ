package ojij.common.id6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {
    Solution2 solution = new Solution2();

    @Test
    void convert() {

        assertEquals("LCIRETOESIIGEDHN", solution.convert("LEETCODEISHIRING", 3));
        assertEquals("LDREOEIIECIHNTSG", solution.convert("LEETCODEISHIRING", 4));
    }
}