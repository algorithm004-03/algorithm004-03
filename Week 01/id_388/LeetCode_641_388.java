/**
 * 双端队列
 */
class MyCircularDeque {

    private int[] queue;
    private int maxSize;
    private int tail;
    private int head;
    private int size;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        maxSize = k;
        queue = new int[k];
        size = 0;
        tail = 0;
        head = k - 1;

    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (size == maxSize) {
            return false;
        }
        queue[head] = value;
        head = (head - 1 + maxSize) % maxSize;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (size == maxSize) {
            return false;
        }
        queue[tail] = value;
        tail = (tail + 1) % maxSize;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        head = (head + 1) % maxSize;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        tail = (tail - 1 + maxSize) % maxSize;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return queue[(head + 1) % maxSize];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return queue[(tail - 1 + maxSize) % maxSize];
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
        return size == maxSize;
    }
}