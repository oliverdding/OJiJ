package ojij.面试题.id16.id01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void swapNumbers() {
        assertArrayEquals(new int[]{5, 2}, solution.swapNumbers(new int[]{2, 5}));
        assertArrayEquals(new int[]{1, 7}, solution.swapNumbers(new int[]{7, 1}));
    }
}