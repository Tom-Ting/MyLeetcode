import org.junit.Test;

import java.util.Stack;

public class T25_H_ListNode {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 零校验
        if (head == null || head.next == null){
            return head;
        }

        // === 变量初始化 ===
        // 虚位首节点，用于结果输出
        ListNode preHead = new ListNode(-1);
        preHead.next = head;
        // 哨兵节点
        ListNode point = head;
        ListNode preStack = preHead;
        // 首节点处理
        Stack<ListNode> stack = new Stack<>();
        stack.push(head);
        int K = 1;

        while (point.next != null){
            point = point.next;
            stack.push(point);
            K++;

            if (K == k){
                K = 0;
                ListNode pointK = stack.pop();
                preStack.next = pointK;
                preStack = preStack.next;
                ListNode postStack = pointK.next;

                for (int i = 1; i < k; i++) {
                    pointK = stack.pop();
                    preStack.next = pointK;
                    preStack = preStack.next;
                }
                preStack.next = postStack;
                point = preStack;
            }
        }
        return preHead.next;
    }

    @Test
    public void Test(){
        reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 2);
        reverseKGroup(new ListNode(new int[]{1,2,3,4,5}), 3);
    }
}
