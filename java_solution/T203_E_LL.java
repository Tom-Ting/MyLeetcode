package org.leetcode;

public class T203_E_LL {
    public ListNode removeElements(ListNode head, int val) {
        ListNode prehead = new ListNode(-1);
        prehead.next = head;
        ListNode point = prehead;
        while(point.next != null){
            if (point.next.val == val){
                point.next = point.next.next;
            }else {
                point = point.next;
            }
        }
        return prehead.next;
    }
}
