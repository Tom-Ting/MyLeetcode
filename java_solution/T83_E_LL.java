package org.leetcode;

import org.junit.Test;

public class T83_E_LinkedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode point = head;
        while(point.next != null){
            if (point.next.val == point.val){
                point.next = point.next.next;
            }else {
                point = point.next;
            }
        }
        return head;
    }

    @Test
    public void Test(){
        ListNode L1A = new ListNode(new int[]{1,1,2});
        ListNode L1 = deleteDuplicates(L1A);
        while (L1 != null){
            System.out.print(L1.val);
            L1 = L1.next;
        }
        System.out.println();

        ListNode L2A = new ListNode(new int[]{});
        ListNode L2 = deleteDuplicates(L2A);
        while (L2 != null){
            System.out.print(L2.val);
            L2 = L2.next;
        }
        System.out.println();

        ListNode L3A = new ListNode(new int[]{1,1,2,3,3});
        ListNode L3 = deleteDuplicates(L3A);
        while (L3 != null){
            System.out.print(L3.val);
            L3 = L3.next;
        }
        System.out.println();
    }
}
