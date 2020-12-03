package ojij.common.id204;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void countPrimes() {
        assertEquals(4, solution.countPrimes(10));
        assertEquals(0, solution.countPrimes(1));
        assertEquals(0, solution.countPrimes(0));
        assertEquals(2, solution.countPrimes(5));
    }
}