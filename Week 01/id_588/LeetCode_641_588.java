import java.util.Arrays;

/**
 * 设计循环双端队列
 * https://leetcode.com/problems/design-circular-deque/
 */
public class LeetCode_641_588 {

    private int[] elements;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public LeetCode_641_588(int k) {
        elements = new int[k];
        front = 0;
        rear = 0;
        size = 0;
        capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == capacity) {
            return false;
        }

        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        size ++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == capacity) {
            return false;
        }

        elements[rear] = value;
        rear = (rear + 1) % capacity;
        size ++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (0 == size) {
            return false;
        }

        front = (front + 1) % capacity;
        size --;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (0 == size) {
            return false;
        }

        rear = (rear - 1 + capacity) % capacity;
        size --;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (0 == size) {
            return -1;
        }
        return elements[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (0 == size) {
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return 0 == size;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }

    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
        LeetCode_641_588 deque = new LeetCode_641_588(8);
        deque.insertFront(5);
        System.out.println(deque.toString());
        deque.insertLast(4);
        System.out.println(deque.toString());
        deque.insertLast(1);
        System.out.println(deque.toString());
        deque.insertLast(3);
        System.out.println(deque.toString());
        deque.insertFront(9);
        System.out.println(deque.toString());
        deque.deleteFront();
        System.out.println(deque.toString());
        deque.deleteLast();
        System.out.println(deque.toString());
        int frontElement = deque.getFront();
        System.out.println(frontElement);
        int rearElement = deque.getRear();
        System.out.println(rearElement);
        boolean isEmpty = deque.isEmpty();
        System.out.println(isEmpty);
        boolean isFull = deque.isFull();
        System.out.println(isFull);
    }
}
