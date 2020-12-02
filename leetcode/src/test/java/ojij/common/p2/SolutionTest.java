package ojij.common.p2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void addTwoNumbers() {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        ListNode result = new ListNode(7);
        result.next = new ListNode(0);
        result.next.next = new ListNode(8);
        assertEquals(solution.addTwoNumbers(l1, l2).val, result.val);
    }
}