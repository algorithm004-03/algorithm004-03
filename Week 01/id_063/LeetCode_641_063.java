/*
链表实现双向链表，无特殊算法，简单链表操作
*/


class MyCircularDeque {
    private class Node {
        int val;
        Node prev;
        Node next;

        Node(int val) {
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int curSize = 0;
    private final int MAX_SIZE;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        MAX_SIZE = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (curSize == MAX_SIZE) {
            return false;
        }

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }

        curSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (curSize == MAX_SIZE) {
            return false;
        }

        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        curSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (curSize == 0) {
            return false;
        }

        if (curSize == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev.next = null;
            head.prev = null;
        }

        curSize--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (curSize == 0) {
            return false;
        }

        if (curSize == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }

        curSize--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (curSize == 0) {
            return -1;
        }

        return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (curSize == 0) {
            return -1;
        }

        return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return (curSize == 0);
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (curSize == MAX_SIZE);
    }
}