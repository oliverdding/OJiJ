package ojij.common.id1;

import java.util.HashMap;
import java.util.Map;

/**
 * 遍历数组每个元素，使用hash表存储target-元素，不断遍历、匹配。
 * 时间复杂度: o(n)
 * 空间复杂度: o(n)
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {

    int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>(); // <needed, position>
        for (int i = nums.length - 1; i >= 0; i--) {
            if (hashMap.containsKey(nums[i])) { // Find needed
                return new int[]{i, hashMap.get(nums[i])};
            }
            hashMap.put(target - nums[i], i);
        }
        return new int[0];
    }

}
