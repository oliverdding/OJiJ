package ojij.common.id34;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    void searchRange() {
        assertArrayEquals(new int[]{3, 4}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6));
        assertArrayEquals(new int[]{-1, -1}, solution.searchRange(new int[]{}, 0));
        assertArrayEquals(new int[]{0, 0}, solution.searchRange(new int[]{1, 5, 6, 7, 7, 8, 8, 10}, 1));
        assertArrayEquals(new int[]{7, 7}, solution.searchRange(new int[]{1, 5, 6, 7, 7, 8, 8, 10}, 10));

    }

    @Test
    void binarySearch() {
        assertEquals(4, solution.binarySearch(new int[]{1, 4, 6, 6, 7, 8, 9}, 7, 0, 6));
        assertEquals(0, solution.binarySearch(new int[]{1, 4, 6, 6, 7, 8, 9}, 1, 0, 6));
        assertEquals(0, solution.binarySearch(new int[]{1}, 1, 0, 1));
        assertEquals(-1, solution.binarySearch(new int[]{1, 4, 6, 6, 7, 8, 9}, 10, 0, 6));
        assertEquals(6, solution.binarySearch(new int[]{1, 4, 6, 6, 7, 8, 9}, 9, 0, 6));
    }
}