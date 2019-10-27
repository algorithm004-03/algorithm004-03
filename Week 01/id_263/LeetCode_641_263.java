package io.beansoft.pencil.leetcode;


/**
 * @author beanlam
 * @version 1.0
 * @date 2019-10-20 17:37
 */
public class LeetCode_641_263 {

}

class MyCircularDeque {

    private int limit;

    private int size = 0;

    private Node head;
    private Node tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.limit = k;
        this.head = new Node();
        this.tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {

        if (size == limit) {
            return false;
        }

        Node front = head.next;

        Node newNode = new Node();
        newNode.value = value;
        newNode.prev = head;
        newNode.next = front;

        head.next = newNode;
        front.prev = newNode;

        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == limit) {
            return false;
        }

        Node last = tail.prev;

        Node newNode = new Node();
        newNode.value = value;
        newNode.next = tail;
        newNode.prev = last;

        last.next = newNode;
        tail.prev = newNode;

        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }

        Node theSecond = head.next.next;
        theSecond.prev = head;
        head.next = theSecond;

        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }

        Node theLeastSecond = tail.prev.prev;
        theLeastSecond.next = tail;
        tail.prev = theLeastSecond;

        size--;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }

        return head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }

        return tail.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == limit;
    }

    static class Node {
        Node prev;
        Node next;
        int value;
    }
}
