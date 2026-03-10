package T146_M_ListNode;

import org.junit.Test;

import java.util.HashMap;

public class LRUCache {
    int capacity;
    int nowCapacity = 0;
    BiListNode cacheHead;
    BiListNode cacheTail;
    HashMap<Integer, BiListNode> map;

    public LRUCache(){
        this(0);
    }

    LRUCache(int capacity){
        this.capacity = capacity;
        cacheHead = new BiListNode(-1);
        cacheTail = new BiListNode(-2);
        cacheHead.next = cacheTail;
        cacheTail.prev = cacheHead;

        map = new HashMap<>();
    }

    int get(int key){
        if (map.containsKey(key)){
            BiListNode node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            cacheTail.prev.next = node;
            node.prev = cacheTail.prev;
            node.next = cacheTail;
            cacheTail.prev = node;

            return node.val;
        }
        return -1;
    }

    void put(int key, int value){
        if (capacity == 0){
            return;
        }
        if (map.containsKey(key)){
            BiListNode node = map.get(key);
            node.val = value;
            node.prev.next = node.next;
            node.next.prev = node.prev;
            cacheTail.prev.next = node;
            node.prev = cacheTail.prev;
            node.next = cacheTail;
            cacheTail.prev = node;
        }else {
            if (nowCapacity == capacity){
                pop();
            }
            BiListNode node = new BiListNode(value);
            cacheTail.prev.next = node;
            node.prev = cacheTail.prev;
            node.next = cacheTail;
            cacheTail.prev = node;

            nowCapacity++;
            map.put(key, node);
        }
    }

    private void pop(){
        if (nowCapacity == 0){
            return;
        }
        BiListNode node = cacheHead.next;
        node.next.prev = cacheHead;
        cacheHead.next = node.next;
        node.prev = null;
        node.next = null;
        nowCapacity--;
        for (Integer key : map.keySet()) {
            if (map.get(key) == node){
                map.remove(key);
                break;
            }
        }
    }

    @Test
    public void Test(){
        /*
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

        LRUCache cache2 = new LRUCache(2);
        cache2.put(1,0);// 0
        cache2.put(2,2);// 0 2
        System.out.println(cache2.get(1)); // 2 0
        cache2.put(3,3); // 0 3
        System.out.println(cache2.get(2)); // -1
        cache2.put(4,4); // 3 4
        System.out.println(cache2.get(1)); // -1
        System.out.println(cache2.get(3)); // 3
        System.out.println(cache2.get(4)); // 4


         */
        LRUCache cache3 = new LRUCache(2);
        cache3.put(2,1);// 2-1
        cache3.put(1,1);// 2-1 1-1
        cache3.put(2,3); // 1-1 2-3
        cache3.put(4,1); // 2-3 4-1
        System.out.println(cache3.get(1)); // -1
        System.out.println(cache3.get(2)); // 3
    }
}
