package ojij.剑指Offer.id52;

import org.junit.jupiter.api.Test;

class Solution2Test {

    Solution2 solution = new Solution2();

    @Test
    void getIntersectionNode() {
        ListNode node0 = new ListNode(3);
        ListNode node1 = new ListNode(2);
        node1.next = node0;
        System.out.println("Find: " + solution.getIntersectionNode(node1, node0).val);
    }
}