package ojij.common.id134;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void canCompleteCircuit() {
        Solution solution = new Solution();
        int[] gas = new int[]{1, 2, 3, 4, 5};
        int[] cost = new int[]{3, 4, 5, 1, 2};
        assertEquals(solution.canCompleteCircuit(gas, cost), 3);
    }
}