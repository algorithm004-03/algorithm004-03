package com.leetcode.kelvin;

/**
 * @author kelvin
 * @date 2019/10/20 7:44 PM
 */
public class MyCircularDeque {
    private int size;
    private int k;
    private Node head;
    private Node tail;

    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.pre = tail;
        tail.next = head;
        this.k = k;
        this.size = 0;
    }

    public boolean insertFront(int value) {
        if (this.isFull()) {
            return false;
        }
        Node node = new Node(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.isFull()) {
            return false;
        }
        Node node = new Node(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        size--;
        return true;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return head.pre.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return tail.next.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return size == k;
    }

    class Node {
        Node pre;
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
