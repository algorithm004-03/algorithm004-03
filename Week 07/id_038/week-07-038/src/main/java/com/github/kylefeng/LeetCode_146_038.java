package com.github.kylefeng;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kylefeng
 * @time 2019/12/1 15:23
 */
public class LeetCode_146_038 {

    static class LRUCache {
        private Map<Integer, Node> cache = new HashMap<>();
        private int count;
        private int capacity;
        private Node head;
        private Node tail;

        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;

            head = new Node();
            head.pre = null;

            tail = new Node();
            tail.next = null;

            head.next = tail;
            tail.pre = head;
        }


        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) {
                return -1;
            }

            this.moveToHead(node);
            return node.value;
        }


        public void put(int key, int value) {
            Node node = cache.get(key);

            if (node == null) {

                Node newNode = new Node();
                newNode.key = key;
                newNode.value = value;

                this.cache.put(key, newNode);
                this.addNode(newNode);

                ++count;

                if (count > capacity) {
                    // pop the tail
                    Node tail = this.popTail();
                    this.cache.remove(tail.key);
                    --count;
                }
            } else {
                // update the value.
                node.value = value;
                this.moveToHead(node);
            }
        }


        private void addNode(Node node) {
            node.pre = head;
            node.next = head.next;

            head.next.pre = node;
            head.next = node;
        }

        private void removeNode(Node node) {
            Node pre = node.pre;
            Node post = node.next;

            pre.next = post;
            post.pre = pre;
        }

        private void moveToHead(Node node) {
            this.removeNode(node);
            this.addNode(node);
        }

        private Node popTail() {
            Node res = tail.pre;
            this.removeNode(res);
            return res;
        }

    }

    static class Node {
        int key;
        int value;
        Node pre;
        Node next;
    }
}
