package ojij.common.id406;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void reconstructQueue() {
        Solution solution = new Solution();
        assertTrue(Arrays.deepEquals(solution.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}),
                new int[][]{{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}}));
    }
}