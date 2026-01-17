package org.leetcode;

import java.util.Stack;

public class T206_E_LL {
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode point = newHead;
        while (!stack.empty()){
            point.next = stack.pop();
            point = point.next;
        }
        point.next = null;
        return newHead;
    }
}
