package org.leetcode;

public class T2_M_LL {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = l1;

        l1.val = l1.val + l2.val;
        int flag = l1.val % 10;
        l1.val = l1.val / 10;

        while (l1.next != null && l2.next != null){
            l1.next.val = l1.next.val + l2.next.val + flag;
            flag = l1.next.val % 10;
            l1.next.val = l1.next.val / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next == null){
            l1.next = l2.next;
            l2.val += flag;
            flag = l2.val%10;
            while (flag > 0){
                l2 = l2.next;
                flag = l2.val % 10;
                l2.val = l2.val / 10;
            }

            return preHead.next;
        }else {
            l1.val += flag;
            return preHead.next;
        }
    }
}
