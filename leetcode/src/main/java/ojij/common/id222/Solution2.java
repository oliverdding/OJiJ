package ojij.common.id222;

/**
 * 方法一非常暴力，且没用到完全二叉树的特性。
 * 因此考虑方法二。如何使用到完全二叉树呢？
 * <p>
 * 对于完全二叉树，每个节点都可以用一串二进制值表示。
 * 这就和二分查找相关了。
 * <p>
 * 首先求出深度(depth)，知道深度也就知道二进制值的长度.(depth - 1)
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution2 {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        TreeNode node = root;
        while (node.left != null) {
            depth++;
            node = node.left;
        }
        int low = 1 << depth, high = (1 << (depth + 1)) - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (exists(root, depth, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean exists(TreeNode root, int depth, int k) {
        int bits = 1 << (depth - 1);
        TreeNode node = root;
        while (node != null && bits > 0) {
            if ((bits & k) == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            bits >>= 1;
        }
        return node != null;
    }
}
