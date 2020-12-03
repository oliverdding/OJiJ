package ojij.common.id283;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @Test
    void moveZeroes() {
        Solution solution = new Solution();
        int[] array = new int[]{
                0, 1, 0, 3, 12
        };
        solution.moveZeroes(array);
        assertArrayEquals(array, new int[]{
                1, 3, 12, 0, 0
        });
    }
}