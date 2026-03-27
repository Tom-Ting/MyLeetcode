import org.junit.Test;

public class T2_M {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode p1 = l1;
        ListNode p2 = l2;
        int HBit = 0;
        int sum;
        while (p1.next != null && p2.next != null) {
            sum = p1.val + p2.val + HBit;
            HBit = sum / 10;
            p1.val = sum % 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        sum = p1.val + p2.val + HBit;
        HBit = sum / 10;
        p1.val = sum % 10;
        if (p1.next == null && p2.next == null) {
            if (HBit == 1) {
                p1.next = new ListNode(1);
            }
        } else {
            if (p2.next != null) { // p1 == null
                p1.next = p2.next;
            }
            p1 = p1.next;
            while (p1.next != null && HBit != 0) {
                sum = p1.val + HBit;
                HBit = sum / 10;
                p1.val = sum% 10;
                p1 = p1.next;
            }
            sum = p1.val + HBit;
            HBit = sum / 10;
            p1.val = sum % 10;
            if (HBit == 1){
                p1.next = new ListNode(1);
            }
        }
         return l1;
    }

    @Test
    public void Test(){
        ListNode l1A = new ListNode(new int[]{2,4,3});
        ListNode l1B = new ListNode(new int[]{5,6,4});
        ListNode a1 = addTwoNumbers(l1A, l1B);
        for (ListNode i = a1; i != null; i = i.next){
            System.out.print(i.val);
        }
        System.out.println();

        ListNode l2A = new ListNode(new int[]{2,4,3,3});
        ListNode l2B = new ListNode(new int[]{5,6,4});
        ListNode a2 = addTwoNumbers(l2A, l2B);
        for (ListNode i = a2; i != null; i = i.next){
            System.out.print(i.val);
        }
        System.out.println();

        ListNode l3A = new ListNode(new int[]{5});
        ListNode l3B = new ListNode(new int[]{5,9,9,9,9,9,9,9,9,99,9});
        ListNode a3 = addTwoNumbers(l3A, l3B);
        for (ListNode i = a3; i != null; i = i.next){
            System.out.print(i.val);
        }
        System.out.println();

        ListNode l4A = new ListNode(new int[]{9,9,9,9,9,9,9});
        ListNode l4B = new ListNode(new int[]{9,9,9,9});
        ListNode a4 = addTwoNumbers(l4A, l4B);
        for (ListNode i = a4; i != null; i = i.next){
            System.out.print(i.val);
        }
    }
}
