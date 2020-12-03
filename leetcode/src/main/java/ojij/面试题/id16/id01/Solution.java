package ojij.面试题.id16.id01;

public class Solution {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = (numbers[1] = (numbers[0] = numbers[1] ^ numbers[0]) ^ numbers[1]) ^ numbers[0];
        return numbers;
    }
}
