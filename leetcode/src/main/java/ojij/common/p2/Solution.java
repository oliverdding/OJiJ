package ojij.common.p2;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode head;
        head = new ListNode();
        ListNode temp = head;
        ListNode next_, m = l1, n = l2;
        do {
            next_ = new ListNode();
            { // 计算得到本位结果与下一位进位
                int result = ((m == null ? 0 : m.val) + (n == null ? 0 : n.val) + flag);
                next_.val = result % 10;
                flag = result / 10;
            }
            temp.next = next_;
            temp = next_;
            if (m != null)
                m = m.next;
            if (n != null)
                n = n.next;
        } while (m != null || n != null || flag != 0);
        return head.next;
    }
}
