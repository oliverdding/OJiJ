package ojij.common.id222;

/**
 * 最简单的思路是用递归的方式分解计算
 *
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        } else if (root.right == null) {
            return 2;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
