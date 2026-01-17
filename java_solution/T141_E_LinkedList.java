package org.leetcode;

import java.util.HashSet;
import java.util.Set;

public class T141_E_LinkedList {
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode point = head;
        while(point.next != null){
            if (set.contains(point)){
                return true;
            }
            set.add(point);
            point = point.next;
        }
        return false;
    }
}
