package com.github.kylefeng.week01;

/**
 * 641. 设计循环双端队列
 *
 * @author kylefeng
 * @time 2019/10/19 10:54
 */
public class LeetCode_641_038 {
    public static class MyCircularDeque {
        /**
         * 队列中的节点，采用双向链表实现
         */
        class Node {
            /**
             * 在节点存储的数据
             */
            int data;

            /**
             * 后继节点指针
             */
            Node next;

            /**
             * 前驱节点指针
             */
            Node prev;
        }

        /**
         * 头节点
         */
        private Node head = new Node();

        /**
         * 尾节点
         */
        private Node tail = new Node();

        /**
         * 最大容量
         */
        private int maxSize;

        /**
         * 当前队列大小
         */
        private int size = 0;

        /**
         * Initialize your data structure here. Set the size of the deque to be k.
         */
        public MyCircularDeque(int k) {
            if (k <= 0) {
                throw new IllegalArgumentException("Size of MyCircularDeque must great than zero");
            }
            this.maxSize = k;
            this.head.next = tail;
            this.tail.prev = head;
        }

        /**
         * Adds an item at the front of Deque. Return true if the operation is successful.
         */
        public boolean insertFront(int value) {
            if (this.size == this.maxSize) {
                return false;
            }

            // setup new node
            Node node = new Node();
            node.data = value;
            node.prev = this.head;
            node.next = this.head.next;

            // setup head
            this.head.next.prev = node;
            this.head.next = node;
            this.size++;
            return true;
        }

        /**
         * Adds an item at the rear of Deque. Return true if the operation is successful.
         */
        public boolean insertLast(int value) {
            if (this.size == this.maxSize) {
                return false;
            }

            // setup new node
            Node node = new Node();
            node.data = value;
            node.next = this.tail;
            node.prev = this.tail.prev;

            // setup tail
            this.tail.prev.next = node;
            this.tail.prev = node;
            this.size++;
            return true;
        }

        /**
         * Deletes an item from the front of Deque. Return true if the operation is successful.
         */
        public boolean deleteFront() {
            if (this.size == 0) {
                return false;
            }

            Node toBeDeleted = this.head.next;
            this.head.next = toBeDeleted.next;
            toBeDeleted.next.prev = this.head;
            toBeDeleted.next = toBeDeleted;
            toBeDeleted.prev = toBeDeleted;
            this.size--;
            return true;
        }

        /**
         * Deletes an item from the rear of Deque. Return true if the operation is successful.
         */
        public boolean deleteLast() {
            if (this.size == 0) {
                return false;
            }

            Node toBeDeleted = this.tail.prev;
            this.tail.prev = toBeDeleted.prev;
            toBeDeleted.prev.next = this.tail;
            toBeDeleted.next = toBeDeleted;
            toBeDeleted.prev = toBeDeleted;
            this.size--;
            return true;
        }

        /**
         * Get the front item from the deque.
         */
        public int getFront() {
            if (this.size == 0) {
                return -1;
            }
            return this.head.next.data;
        }

        /**
         * Get the last item from the deque.
         */
        public int getRear() {
            if (this.size == 0) {
                return -1;
            }
            return this.tail.prev.data;
        }

        /**
         * Checks whether the circular deque is empty or not.
         */
        public boolean isEmpty() {
            return this.size == 0;
        }

        /**
         * Checks whether the circular deque is full or not.
         */
        public boolean isFull() {
            return this.size == this.maxSize;
        }
    }

}
