package ojij.common.id670;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void maximumSwap() {
        assertEquals(7236, solution.maximumSwap(2736));
        assertEquals(97326, solution.maximumSwap(27396));
        assertEquals(0, solution.maximumSwap(0));
        assertEquals(9765438, solution.maximumSwap(8765439));
    }
}