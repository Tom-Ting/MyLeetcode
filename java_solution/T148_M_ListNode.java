import org.junit.Test;

public class T148_M_ListNode {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail){
        if (head == null){
            return null;
        }
        if (head.next == tail){
            // 这是神来之笔，为什么？
            head.next = null;
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != tail){
            fast = fast.next;
            slow = slow.next;
            if (fast != tail){
                fast = fast.next;
            }
        }

        ListNode midNode = slow;
        ListNode List1 = sortList(head, midNode);
        ListNode List2 = sortList(midNode, tail);

        return mergeList(List1, List2);
    }

    public ListNode mergeList(ListNode List1, ListNode List2){
        ListNode prePoint = new ListNode(-1);
        ListNode head = prePoint;
        ListNode point1 = List1;
        ListNode point2 = List2;

        while (point1 != null && point2 != null){
            if (point1.val < point2.val){
                prePoint.next = point1;
                point1 = point1.next;
            }else {
                prePoint.next = point2;
                point2 = point2.next;
            }
            prePoint = prePoint.next;
        }
        if (point1 == null){
            prePoint.next = point2;
        }else {
            prePoint.next = point1;
        }
        return head.next;
    }

    @Test
    public void Test(){
        ListNode head1 = new ListNode(new int[]{4,2,1,3});
        sortList(head1);

        ListNode head2 = new ListNode(new int[]{-1,5,3,4,0});
        sortList(head2);

        ListNode head3 = new ListNode(new int[0]);
        sortList(head3);
    }
}
