package ojij.common.id147;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    Solution solution = new Solution();

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print("[" + head.val + "] ");
            head = head.next;
        }
        System.out.println("");
    }

    @Test
    void insertionSortList() {

        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head = solution.insertionSortList(head);
        printList(head);
        assertEquals(head.val, 1);
        assertEquals(head.next.val, 2);
        assertEquals(head.next.next.val, 3);
        assertEquals(head.next.next.next.val, 4);

    }
}