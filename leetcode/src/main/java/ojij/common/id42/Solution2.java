package ojij.common.id42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 考虑使用栈来解决。对每列遍历:
 * 1. 若栈顶非空，且当前列高于栈顶高度
 * 1) 出栈栈顶元素
 * 2) 计算长、高
 * 3) 计算水
 * 2. 当前索引入栈
 * <p>
 * 时间复杂度: o(n)
 * 空间复杂度: o(n)
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution2 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) { // 当前高度高于栈顶
                Integer pop = stack.pop();
                if (stack.isEmpty()) // 最后一个元素
                    break;
                int boundWidth = i - stack.peek() - 1;
                int boundHeight = Math.min(height[i], height[stack.peek()]) - height[pop]; // 一个一个算。同高的块将会被忽视(单单弹出)
                result += boundHeight * boundWidth;
            }
            stack.push(i);
        }
        return result;
    }
}
