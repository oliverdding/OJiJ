package ojij.剑指Offer.id52;

import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<Integer> hashSet = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (hashSet.contains(headA.hashCode())) {
                    return headA;
                } else {
                    hashSet.add(headA.hashCode());
                    headA = headA.next;
                }
            }
            if (headB != null) {
                if (hashSet.contains(headB.hashCode())) {
                    return headB;
                } else {
                    hashSet.add(headB.hashCode());
                    headB = headB.next;
                }
            }
        }
        return null;
    }
}
