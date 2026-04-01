import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class T23_H {
    public ListNode mergeKLists(ListNode[] lists) {
        int L = lists.length;
        if (L == 0){
            return null;
        }
        Queue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < L; i++) {
            ListNode node = lists[i];
            if (node != null){
                q.offer(node);
            }
        }
        ListNode preHead = new ListNode(-1);
        ListNode point = preHead;
        while (!q.isEmpty()){
            ListNode node = q.poll();
            point.next = node;
            point = point.next;
            if (node.next != null){
                q.offer(node.next);
            }
        }
        return preHead.next;
    }
}
