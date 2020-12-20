package ojij.剑指Offer.id21;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), temp = head;
        while (l1 != null || l2 != null) {
            while (l1 != null && (l2 == null || l1.val <= l2.val)) {
                temp.next = l1;
                l1 = l1.next;
                temp = temp.next;
            }
            while (l2 != null && (l1 == null || l2.val <= l1.val)) {
                temp.next = l2;
                l2 = l2.next;
                temp = temp.next;
            }
        }
        return head.next;
    }
}
