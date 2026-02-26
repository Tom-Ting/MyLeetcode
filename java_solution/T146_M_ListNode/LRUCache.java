package T146_M_ListNode;

import org.junit.Test;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    int nowCapacity = 0;
    BiListNode cacheHead = new BiListNode(-1);
    BiListNode cacheTail = cacheHead;
    HashMap<Integer, BiListNode> map = new HashMap<>();

    public LRUCache(){
        this(0);
    }

    LRUCache(int capacity){
        this.capacity = capacity;
    }

    int get(int key){
        if (map.containsKey(key)){
            BiListNode node = map.get(key);
            BiListNode point = node;
            while (point.next != null){
                point = point.next;
            }
            if (node.prev != null){
                node.prev.next = node.next;
            }
            if (node.next != null){
                node.next.prev = node.prev;
            }
            node.prev = point;
            point.next = node;
            node.next = null;
            cacheTail = node;
            return node.val;
        }
        return -1;
    }

    void put(int key, int value){
        if (map.containsKey(key)){
            BiListNode node = map.get(key);
            node.val = value;
            BiListNode point = node;
            while (point.next != null){
                point = point.next;
            }
            if (node.prev != null){
                node.prev.next = node.next;
            }
            if (node.next != null){
                node.next.prev = node.prev;
            }
            node.prev = point;
            point.next = node;
            node.next = null;
            cacheTail = node;
        }else {
            if (nowCapacity == capacity){
                pop();
                map.remove(key);
            }
            BiListNode node = new BiListNode(value);
            cacheTail.next = node;
            node.prev = cacheTail;
            cacheTail = node;
            nowCapacity++;
            map.put(key, node);
            if (nowCapacity == 1){
                cacheHead = node;
            }
        }
    }

    private void pop(){
        if (nowCapacity == 0){
            return;
        }
        BiListNode node = cacheHead;
        cacheHead = cacheHead.next;
        cacheHead.prev = null;
        node.next = null;
        nowCapacity--;
    }

    @Test
    public void Test(){
        int N;
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        N = cache.get(1);
        cache.put(3,3);
        N = cache.get(2);
        cache.put(4,4);
        N = cache.get(1);
        N = cache.get(3);
        N = cache.get(4);
    }
}
