package org.leetcode;

import org.junit.Test;

import java.util.Stack;

public class T234_E_LL {
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode point = head;
        while (point != null){
            stack.push(point);
            point = point.next;
        }
        point = head;
        while (!stack.empty()){
            ListNode temp = stack.pop();
            if (temp.val !=point.val){
                return false;
            }
            point = point.next;
        }
        return true;
    }

    @Test
    public void Test(){
        ListNode L1A = new ListNode(new int[]{1,2,2,1});
        System.out.println(isPalindrome(L1A));
    }
}
