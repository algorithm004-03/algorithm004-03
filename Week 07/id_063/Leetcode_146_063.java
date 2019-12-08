import java.util.HashMap;
import java.util.Map;

class LRUCache {

    private class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int cap;
    Map<Integer, Node> key2node;

    public LRUCache(int capacity) {
        head = new Node(0 ,0);
        tail = new Node(0, 0);

        head.prev = tail;
        head.next = null;
        tail.next = head;
        tail.prev = null;

        key2node = new HashMap<>();

        cap = capacity;
    }

    private void moveToTail(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        tail.next.prev = node;
        node.next = tail.next;
        node.prev = tail;
        tail.next = node;
    }

    private Node removeFromHead() {
        Node ret = head.prev;

        head.prev.prev.next = head;
        head.prev = head.prev.prev;

        return ret;
    }

    private void addToTail(int key, int val) {
        Node node = new Node(key, val);

        node.next = tail.next;
        node.prev = tail;
        tail.next.prev = node;
        tail.next = node;
    }

    private Node getTail() {
        return tail.next;
    }

    public int get(int key) {
        if (key2node.containsKey(key)) {
            Node node = key2node.get(key);
            moveToTail(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        if (key2node.containsKey(key)) {
            Node node = key2node.get(key);
            node.val = value;
            moveToTail(node);
        } else {
            if (key2node.size() == cap) {
                key2node.remove(removeFromHead().key);
            }

            addToTail(key, value);
            key2node.put(key, getTail());
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        cache.get(2);       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        cache.get(1);       // 返回 -1 (未找到)
        cache.get(3);       // 返回  3
        cache.get(4);       // 返回  4
    }
}
