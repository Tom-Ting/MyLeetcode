package T138_M_ListNode;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null){
            return null;
        }
        Node newHead = new Node(head.val);
        Node oldPoint = head;
        Node newPoint = newHead;

        Map<Node, Node> old2new = new HashMap<>();
        old2new.put(oldPoint, newPoint);

        oldPoint = oldPoint.next;

        while(oldPoint != null){
            newPoint.next = new Node(oldPoint.val);
            newPoint = newPoint.next;
            old2new.put(oldPoint, newPoint);
            oldPoint = oldPoint.next;
        }

        oldPoint = head;
        newPoint = newHead;

        while (oldPoint != null){
            if (oldPoint.random != null){
                newPoint.random = old2new.get(oldPoint.random);
            }
            oldPoint = oldPoint.next;
            newPoint = newPoint.next;
        }
        return newHead;
    }
}