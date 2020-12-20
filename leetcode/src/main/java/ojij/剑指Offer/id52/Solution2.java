package ojij.剑指Offer.id52;

public class Solution2 {
    public ListNode getIntersectionNode(final ListNode headA, final ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        boolean h1InA = true;
        boolean h2InB = true;
        ListNode h1 = headA;
        ListNode h2 = headB;
        do {
            System.out.printf("%d %d\n", h1.val, h2.val);
            if (h1.hashCode() == h2.hashCode()) {
                return h1;
            }
            h1 = h1.next;
            h2 = h2.next;
            if (h1 == null) {
                if (h1InA) {
                    h1 = headB;
                } else {
                    h1 = headA;
                }
                h1InA = !h1InA;
            }
            if (h2 == null) {
                if (h2InB) {
                    h2 = headA;
                } else {
                    h2 = headB;
                }
                h2InB = !h2InB;
            }
        } while (h1 != headA || h2 != headB);
        return null;
    }
}
