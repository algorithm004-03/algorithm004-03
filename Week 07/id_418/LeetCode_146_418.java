package com.ljg.leetcode.week07.a05;

/**
 * LruCache
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        // cache.put(1, 1);
        // cache.put(2, 2);
        // cache.get(1); // 返回 1
        // cache.put(3, 3); // 该操作会使得密钥 2 作废
        // cache.get(2); // 返回 -1 (未找到)
        // cache.put(4, 4); // 该操作会使得密钥 1 作废
        // cache.get(1); // 返回 -1 (未找到)
        // cache.get(3); // 返回 3
        // cache.get(4); // 返回 4

        cache.put(2, 1);
        cache.put(1,1);
        cache.put(2, 3);
        cache.put(4, 1);
        cache.get(1);
        cache.get(2);

//         ["LRUCache","put","put","put","put","get","get"]
// [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]

    }

    private int capacity;
    private Node head;

    private int size;

    private static class Node {
        private int key;
        private int value;
        private Node next;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        Node node = new Node();
        this.head = node;
    }

    public int get(int key) {
        if (head == null) {
            return -1;
        }
        int count = 0;
        Node temp = head.next;
        Node preNode = head;
        while (temp != null) {
            if (temp.key == key) {

                // 将当前node置顶，并返回
                preNode.next = temp.next;
                temp.next = head.next;
                head.next = temp;

                return temp.value;
            }
            count++;

            preNode = temp;
            temp = temp.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        int count = 0;

        Node temp = head.next;

        if (capacity == 1) {
            if (head.next == null) {
                // 添加
                Node node = new Node();
                node.key = key;
                node.value = value;
                head.next = node;
            } else {
                head.next.key = key;
                head.next.value = value;
            }
            return;
        }

        Node preNode = head;

        while (temp != null) {
            if (temp.key == key) {
                temp.value = value;

                preNode.next = temp.next;
                temp.next = head.next;
                head.next = temp;
                return;
            }
            count++;

            if (count == (capacity - 1)) {
                if (temp.next == null) {
                    continue;
                } else if (temp.next.key == key) {
                    temp.next.value = value;
                    Node tailNode = temp.next;
                    temp.next = null;
                    tailNode.next = head.next;
                    head.next = tailNode;
                    return;
                } else {
                    // 删除最后一个元素
                    temp.next = null;
                    count++;
                    break;
                }
            }

            preNode = temp;
            temp = temp.next;
        }

        Node node = new Node();
        node.key = key;
        node.value = value;
        node.next = head.next;

        head.next = node;
        size++;
    }
}