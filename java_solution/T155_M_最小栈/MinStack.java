package T155_M_最小栈;

import java.util.List;

public class MinStack {
    BiListNode head;
    BiListNode tail;

    public MinStack() {
        this.head = new BiListNode(-1);
        this.tail = new BiListNode(-2);
        this.head.next = this.tail;
        this.tail.next = this.head;
    }

    public void push(int val) {
        BiListNode node = new BiListNode(val);
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
    }

    public void pop() {
        if (isEmpty()){
            return;
        }
        BiListNode node = tail.prev;
        node.prev.next = tail;
        tail.prev = node.prev;
        node.prev = null;
        node.next = null;
    }

    public int top() {
        if (isEmpty()){
            return -1;
        }
        return tail.prev.val;
    }

    public int getMin() {
        return 0;
    }

    public boolean isEmpty(){
        return head.next == tail;
    }
}
