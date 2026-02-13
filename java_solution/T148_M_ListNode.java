import org.junit.Test;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class T148_M_ListNode {
    public ListNode sortList(ListNode head) {
        List<ListNode> NodeList = new ArrayList<>();
        ListNode point = head;
        while (point != null){
            InsertAndSort(NodeList, point);
            point = point.next;
        }

        ListNode preHead = new ListNode(-1);
        point = preHead;

        for (int i = 0; i < NodeList.size(); i++) {
            point.next = NodeList.get(i);
            point = point.next;
        }
        return preHead.next;
    }

    public void InsertAndSort(List<ListNode> NodeList, ListNode node){
        if (NodeList.isEmpty()){
            NodeList.add(node);
            return;
        }
        int left = 0;
        int right = NodeList.size()-1;

        while(left <= right){
            int mid = (left + right)/2;
            if (NodeList.get(mid).val == node.val){
                NodeList.add(mid, node);
                return;
            }else if (NodeList.get(mid).val < node.val){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        NodeList.add(left, node);
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
