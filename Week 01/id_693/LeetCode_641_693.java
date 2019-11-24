package id_693;

/**
 * @Desc 641. 设计循环双端队列   https://leetcode-cn.com/problems/design-circular-deque/
 * @Auther 李雷(KyLin)
 * @Date 2019/10/20
 */
public class LeetCode_641_693 {
    /*
    注意事项，front：直接把元素赋值到当前front的下标，然后把元素下标 - 1 (用求余避免下标越界)，那么front指向 (front - 1 + capacity) % capacity 也就是上一个元素下标的位置，如果是0则指向最后
              rear： 直接把rear下标 + 1 (同样用求雨避免越界)，然后把元素赋值给新的rear，那么rear指着最后的元素

    特别注意：front 和rear都是0的时候处理
    * */
    int front;
    int rear;
    int capacity;
    int size;
    int[] elements;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public LeetCode_641_693(int k) {
        this.elements = new int[k];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
        this.capacity = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (front == rear && size == capacity) {
            return false;
        }
        elements[front] = value;
        front = (front - 1 + capacity) % capacity;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (front == rear && size == capacity) {
            return false;
        }
        rear = (rear + 1 + capacity) % capacity;
        elements[rear] = value;
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
        front = (front + 1 + capacity) % capacity;
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
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        return size == 0 ? -1 : elements[(front + 1 + capacity) % capacity];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        return size == 0 ? -1 : elements[rear];
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
        return size == capacity;
    }
}

/**
 * Your LeetCode_641_693 object will be instantiated and called as such:
 * LeetCode_641_693 obj = new LeetCode_641_693(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */