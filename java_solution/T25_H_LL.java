package org.leetcode;

import org.junit.Test;

public class T25_H_LinkedList {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1){
            return head;
        }
        ListNode L = new ListNode(-1);
        L.next = head;
        while(L != null && L.next != null){
            while (head != null){
                System.out.println(head.val);
                head = head.next;
            }
            ListNode R = L;
            for (int i = 0; i < k; i++) {
                if (R == null){
                    return head;
                }
                R = R.next;
            }
            ListNode l = L.next;
            ListNode m = l.next;
            ListNode r = R.next;
            L = R;
            for (int i = 1; i < k; i++) {
                l.next = r;
                r = l;
                l = m;
                m = l.next;
            }
        }
        return head;
    }

    @Test
    public void Test(){
        ListNode testNode = reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 2);
        while (testNode != null){
            System.out.println(testNode.val);
            testNode = testNode.next;
        }
    }
}
/*
    我只能想到多指针解法

 */
