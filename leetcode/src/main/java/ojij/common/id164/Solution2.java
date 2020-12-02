package ojij.common.id164;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 方案一是因为使用数组导致OOM
 * 于是考虑使用链表，或者更进一步，使用hashmap
 * 但是由于排序算法上的问题，导致的OOT
 * 因为在最后反向排序时步进为1，导致循环次数过多
 */
public class Solution2 {
    public int maximumGap(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < min)
                min = nums[i];
            else if (nums[i] > max)
                max = nums[i];
        }
        Map<Integer, Integer> counting = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) { // 计算次数
            if (counting.containsKey(nums[i] - min)) {
                counting.put(nums[i] - min, counting.get(nums[i] - min) + 1);
            } else {
                counting.put(nums[i] - min, 1);
            }
        }
        int increment = 0;
        for (int i = min; i <= max; i++) {
            if (counting.containsKey(i - min)) {
                int temp = counting.get(i - min);
                for (int j = 0; j < temp; j++) {
                    // in place, may not stable if you care
                    nums[increment++] = i;
                }
            }
        }
        int maxGap = 0;
        for (int i = nums.length - 1; i != 0; i--) {
            if (nums[i] - nums[i - 1] > maxGap) {
                maxGap = nums[i] - nums[i - 1];
            }
        }
        return maxGap;
    }
}
