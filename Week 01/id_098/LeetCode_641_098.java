class MyCircularDeque {

    private int[] array;
    private int front;
    private int last;
    private int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        size = k + 1;
        array= new int[size];
        front = 0;
        last = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + size) % size;
        array[front] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        array[last] = value;
        last = (last + 1) % size;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        last = (last - 1 + size) % size;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return array[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (isEmpty()) return -1;
        return array[(last - 1 + size) % size];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return front == last;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return front == (last + 1) % size;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

//最优化 双端循环队列方案，设置另外变量count 数组是否满或者空，无空间浪费！！ （他人答案）
class MyCircularDeque {

    private int[] q;
    private int head, tail, len;

    public MyCircularDeque(int k) {
        this.q = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        if (!isEmpty()) head = (head - 1 + q.length) % q.length;
        q[head] = value;
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        if (!isEmpty()) tail = (tail + 1) % q.length;
        q[tail] = value;
        len++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (len > 1) head = (head + 1) % q.length;
        len--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (len > 1) tail = (tail - 1 + q.length) % q.length;
        len--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1: q[head];
    }

    public int getRear() {
        return isEmpty() ? -1: q[tail];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == q.length;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */