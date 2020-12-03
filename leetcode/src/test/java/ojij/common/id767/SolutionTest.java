package ojij.common.id767;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void reorganizeString() {
        Solution solution = new Solution();
        assertEquals("bsfbr", solution.reorganizeString("bfrbs"));
    }
}