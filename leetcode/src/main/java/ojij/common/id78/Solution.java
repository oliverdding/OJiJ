package ojij.common.id78;

import java.util.ArrayList;
import java.util.List;

/**
 * 因为要幂等集，考虑使用二进制表示添加与否。
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {

    /**
     * 根据传入的binary来提取nums中的值，生成相应的List返回。
     * <p>
     * 注意：要求binary位数与nums长度一致。
     *
     * @param nums   待提取数组
     * @param binary 判断是否保留的位
     * @return List
     */
    private List<Integer> genList(int[] nums, int binary) {
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if ((binary & 1) == 1) {
                result.add(num);
            }
            binary >>= 1;
        }
        return result;
    }

    /**
     * 传入不含重复元素的整数数组，返回所有可能的子集。
     *
     * @param nums 不含重复元素的整数数组
     * @return 所有可能的子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0)
            result.add(new ArrayList<>());
        else {
            for (int i = ((1 << nums.length) - 1); i >= 0; i--) {
                result.add(genList(nums, i));
            }
        }
        return result;
    }
}
