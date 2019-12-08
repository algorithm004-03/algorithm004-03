import java.util.Stack;
class MyCircularDeque {

    /**
     * 预计用数组 + hashmap 来实现，HashMap 保存头尾信息
     * 不过这样插入 弹出效率太低，还是考虑 用两个栈
     */
    private Stack<Integer> end = new Stack();
    private Stack<Integer> top = new Stack();
    private int MAX = 1000;
    private int currentSize = 0;
    private int initSize = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        if (k > 1000) {
            throw new OutOfMemoryError("exception , out of maxsize");
        }

        initSize = k;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public synchronized boolean  insertFront(int value) {

        if (isFull()) {
            return false;
        }

        top.push(value);

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public synchronized boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        end.push(value);
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public synchronized boolean deleteFront() {
        if(isEmpty()) {
            return false;
        }
        try {
            if (top.size()>0) {
                top.pop();
                return true;
            }

            if (end.size()>0) {
                end.removeElementAt(0);
                return true;
            }

        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public synchronized boolean deleteLast() {
        if(isEmpty()) {
            return false;
        }
        try {
            if (end.size()>0) {
                end.pop();
                return true;
            }

            if (top.size()>0) {
                top.removeElementAt(0);
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if(top.size()>0) {
            return top.peek();
        }

        if (end.size()>0) {
            return end.get(0);
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (end.size()>0) {
            return end.peek();
        }

        if(top.size()>0) {
            return top.get(0);
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        if (top.isEmpty()&&end.isEmpty()) {
            return true;
        }

        return false;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        if (top.size()+end.size()==initSize) {
            return true;
        }

        return false;
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