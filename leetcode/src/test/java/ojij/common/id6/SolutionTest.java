package ojij.common.id6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void convert() {

        assertEquals("LCIRETOESIIGEDHN", solution.convert("LEETCODEISHIRING", 3));
        assertEquals("LDREOEIIECIHNTSG", solution.convert("LEETCODEISHIRING", 4));
    }
}