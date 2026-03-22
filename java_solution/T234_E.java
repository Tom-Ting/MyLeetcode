import org.junit.Test;

import java.util.Stack;

public class T234_E {
    /**
     * 我的解法：两次遍历。利用栈的特点
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return false;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode point = head;
        while (point != null){
            stack.push(point);
            point = point.next;
        }
        point = head;
        while (!stack.empty()){
            ListNode temp = stack.pop();
            if (temp.val !=point.val){
                return false;
            }
            point = point.next;
        }
        return true;
    }

    /**
     * 我的优化解法思路：使用快慢指针。快指针一次移动两个节点，慢指针一次移动一个节点。在快指针到头前，慢指针指向的元素入栈。快指针到头后，慢指针指向的元素出栈比对。当然要进行奇偶校验。
     * 在时间上，只需要遍历一次。
     */
    public boolean isPalindrome2(ListNode head) {

        return true;
    }

    @Test
    public void Test(){
        ListNode L1A = new ListNode(new int[]{1,2,2,1});
        System.out.println(isPalindrome(L1A));
    }
}
