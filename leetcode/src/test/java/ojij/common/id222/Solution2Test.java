package ojij.common.id222;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {

    TreeNode root;

    @BeforeEach
    void constructTree() {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
    }


    @Test
    void countNodes() {
        Solution2 solution = new Solution2();
        assertEquals(solution.countNodes(root), 4);
    }
}