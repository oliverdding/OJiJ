package ojij.common.id393;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void test() {
        assertTrue(solution.validUtf8(new int[]{197, 130, 1}));
        assertFalse(solution.validUtf8(new int[]{235, 140, 4}));
    }

}