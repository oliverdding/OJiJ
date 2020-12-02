package ojij.common.id1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {
    Solution solution = new Solution();
    @Test
    void twoSum() {
        assertArrayEquals(solution.twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        assertArrayEquals(solution.twoSum(new int[]{1, 2, 3, 5, 6, 11, 15}, 8), new int[]{2, 3});
    }
}