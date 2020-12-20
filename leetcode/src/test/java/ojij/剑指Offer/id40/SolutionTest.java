package ojij.剑指Offer.id40;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SolutionTest {

    Solution solution = new Solution();

    void getLeastNumbers() {
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{8, 3, 5, 2, 1, 1}, 2)));
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{8, 3, 5, 2, 1, 1}, 0)));
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{8, 3, 5, 2, 1, 1}, 1)));
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{8, 3, 5, 2, 1, 1}, 5)));
    }

    @Test
    void getLeastNumbers2() {
        System.out.println(Arrays.toString(solution.getLeastNumbers(new int[]{8, 3, 5}, 3)));
    }


}