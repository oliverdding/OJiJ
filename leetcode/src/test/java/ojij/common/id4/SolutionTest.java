package ojij.common.id4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    void findMedianSortedArrays() {
        assertEquals(2.0,
                solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.5,
                solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        assertEquals(0.0,
                solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        assertEquals(1.0,
                solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
        assertEquals(2.0,
                solution.findMedianSortedArrays(new int[]{2}, new int[]{}));
    }
}