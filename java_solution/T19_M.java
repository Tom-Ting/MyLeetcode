import org.junit.Test;

public class T19_M {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode right = head;
        ListNode ans = new ListNode(-1);
        ans.next = head;
        ListNode left = ans;
        if (head.next == null){
            return null;
        }
        for (int i = 0; i < n-1; i++) {
            right = right.next;
        }
        while (right.next != null){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return ans.next;
    }

    @Test
    public void Test(){
//        System.out.println(removeNthFromEnd(new ListNode(1,2,3,4,5), 1));
//        System.out.println(removeNthFromEnd(2));
    }
}