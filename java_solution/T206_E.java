import java.util.Stack;

public class T206_E {
    /**
     * 我的题解：栈
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode point = newHead;
        while (!stack.empty()){
            point.next = stack.pop();
            point = point.next;
        }
        point.next = null;
        return newHead;
    }

    /**
     * 我的参考解法：迭代
     */
    public ListNode reverseList2(ListNode head) {
        ListNode newHead = null;
        ListNode oldHead = head;
        while (oldHead != null){
            ListNode oldNext = oldHead.next;
            oldHead.next = newHead;
            newHead = oldHead;
            oldHead = oldNext;
        }
        return newHead;
    }
}
