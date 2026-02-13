import org.junit.Test;

import java.util.Stack;

public class T24_M_ListNode {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        ListNode preStack = preHead;
        ListNode point = head;
        boolean isSingle = true;
        Stack<ListNode> stack = new Stack<>();
        stack.push(point);

        while (point.next != null){
            point = point.next;
            stack.push(point);
            isSingle = !isSingle;

            // 如果存入了两个节点
            if (!isSingle){
                ListNode first = stack.pop();
                ListNode second = stack.pop();
                second.next = first.next;
                first.next = second;
                preStack.next = first;
                preStack = second;
                point = second;
            }
        }
        return preHead.next;
    }

    @Test
    public void Test(){
        swapPairs(new ListNode(new int[]{1,2,3,4}));
    }
}
