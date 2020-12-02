package ojij.common.id42;

/**
 * <p>将求解分解为每一列。对于每一列能存多多少水，有三个因素共同影响:</p>
 * <ul>
 * <li>这列左边的最高高度。</li>
 * <li>这列右边的最高高度。</li>
 * <li>这列的高度。</li>
 * </ul>
 * <p>也就是需要两次循环求出每一列的左、右最高数组，再循环一次求出每一列能存的水。为了减少一次循环，我们将求解合入。</p>
 * <ul>
 * <li>间复杂度: o(n)</li>
 * <li>空间复杂度: o(n)</li>
 * </ul>
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public int trap(int[] height) {
        int result = 0; // max = 3x10^9
        int[] leftHighest = new int[height.length];
        int[] rightHighest = new int[height.length];
        for (int i = 1; i < height.length; i++) { // 求解左最高
            leftHighest[i] = Math.max(leftHighest[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) { // 求解右最高。将最后求解合并到求解右最高的循环中
            // 事实上，左、右最高的数组中第一个和最后一个一定是0，也就是说不用求、不用计算result
            rightHighest[i] = Math.max(rightHighest[i + 1], height[i + 1]);
            result += Math.max(Math.min(leftHighest[i], rightHighest[i]) - height[i], 0);
        }
        return result;
    }
}
