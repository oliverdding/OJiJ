package ojij.common.id42;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {
    Solution2 solution = new Solution2();

    @Test
    void trap() {

        assertEquals(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}), 6);
        assertEquals(solution.trap(new int[]{4, 2, 0, 3, 2, 5}), 9);
    }
}