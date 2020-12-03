package ojij.common.id976;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void largestPerimeter() {
        assertEquals(5, solution.largestPerimeter(new int[]{2, 1, 2}));
        assertEquals(0, solution.largestPerimeter(new int[]{1, 2, 1}));
        assertEquals(10, solution.largestPerimeter(new int[]{3, 2, 3, 4}));
        assertEquals(8, solution.largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}