package org.leetcode;

import org.junit.Test;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){
        this.val = val;
        this.next = null;
    }

    ListNode(int val,ListNode next){
        this.val = val;
        this.next = next;
    }

    ListNode(int[] vals){
        if (vals == null || vals.length == 0){
            return;
        }

        this.val = vals[0];
        ListNode current = this;

        for (int i = 1; i < vals.length; i++) {
            current.next = new ListNode(vals[i]);
            current = current.next;
        }
    }
}

public class T21_E_LinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 处理空值
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode prehead = new ListNode(-1);
        prehead.next = list1.val < list2.val ? list1:list2;
        ListNode point = prehead;
        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                point.next = list1;
                point = point.next;
                list1 = list1.next;
            }else {
                point.next = list2;
                point = point.next;
                list2 = list2.next;
            }
        }
        point.next = list1==null?list2:list1;

        return prehead.next;
    }

    @Test
    public void Test(){
        ListNode L1A = new ListNode(new int[]{1,2,4});
        ListNode L1B = new ListNode(new int[]{1,3,4});
        ListNode L1C = mergeTwoLists(L1A, L1B);
        while (L1C != null){
            System.out.print(L1C.val);
            L1C = L1C.next;
        }
        System.out.println();

        ListNode L2A = new ListNode(new int[]{});
        ListNode L2B = new ListNode(new int[]{});
        ListNode L2C = mergeTwoLists(L2A, L2B);
        while (L2C != null){
            System.out.print(L2C.val);
            L2C = L2C.next;
        }
        System.out.println();

        ListNode L3A = new ListNode(new int[]{});
        ListNode L3B = new ListNode(new int[]{0});
        ListNode L3C = mergeTwoLists(L3A, L3B);
        while (L3C != null){
            System.out.print(L3C.val);
            L3C = L3C.next;
        }
        System.out.println();
    }
}
