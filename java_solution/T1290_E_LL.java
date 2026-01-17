package org.leetcode;

public class T1290_E_LL {
    public int getDecimalValue(ListNode head) {
        if (head == null){
            return 0;
        }
        int ans = 0;
        while (head != null){
            ans = ans*2 + head.val;
            head = head.next;
        }
        return ans;
    }
}
