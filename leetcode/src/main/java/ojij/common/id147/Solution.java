package ojij.common.id147;


/**
 * @author OliverDD
 * @version 1.0.0
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode sortedTail = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val <= sortedTail.val) { // 需要进一步操作
                ListNode ptr = preHead; // 头部也可插入
                while (ptr.next != cur) { // 确保ptr和cur之间至少差一个
                    if (ptr.next.val >= cur.val) { // 将cur插入到ptr后一位
                        sortedTail.next = cur.next; // 首先将cur移除
                        cur.next = ptr.next;
                        ptr.next = cur;
                        break;
                    }
                    ptr = ptr.next;
                }
            } else { // 不必插入
                sortedTail = sortedTail.next;
            }
            cur = sortedTail.next;
        }
        head = preHead.next;
        preHead.next = null;
        return head;
    }
}
