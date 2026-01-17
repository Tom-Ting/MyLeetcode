package org.leetcode;

public class T876_E_LL {
    public ListNode middleNode(ListNode head) {
        ListNode RPoint = head;
        ListNode LPoint = head;
        boolean Go = true;
        while (RPoint.next != null){
            RPoint = RPoint.next;
            if (Go){
                LPoint = LPoint.next;
            }
            Go = !Go;
        }
        return LPoint;
    }
}
