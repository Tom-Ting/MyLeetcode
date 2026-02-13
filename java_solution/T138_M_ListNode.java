import java.util.ArrayList;
import java.util.List;
/*
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

public class T138_M_ListNode {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(head.val);
        if (head.next == null){
            newHead.next = null;
        }else {
            newHead.next = new Node(head.next.val);
        }
        Node pointOld = head;
        Node pointNew = newHead;

        List<Node> oldNodeList = new ArrayList<>();
        List<Node> newNodeList = new ArrayList<>();

        while (pointOld != null){
            if (pointOld.next != null){
                pointNew.next = new Node(pointOld.next.val);
                oldNodeList.add(pointOld);
                newNodeList.add(pointNew);
                pointNew = pointNew.next;
            }else {
                pointNew.next = null;
            }
            pointOld = pointOld.next;
        }

        pointOld = head;
        pointNew = newHead;

        while (pointOld != null){
            if (head.random == null){
                newHead.random = null;
            }else {
                newHead.random = newNodeList.get(oldNodeList.indexOf(head.random));
            }
            pointOld = pointOld.next;
            pointNew = pointNew.next;
        }
        return newHead;
    }
}

 */
