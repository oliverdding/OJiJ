package ojij.common.id7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void reverse() {
        assertEquals(4321, solution.reverse(1234));
        assertEquals(0, solution.reverse(0));
        assertEquals(0, solution.reverse(1534236469));
    }
}