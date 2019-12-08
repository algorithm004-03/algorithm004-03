/*
 * @lc app=leetcode.cn id=641 lang=cpp
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
private:
    vector<int> mydeque;
    int front, rear, count;
    int size;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        front = 0;
        rear = 0;
        count = 0;
        mydeque = vector<int>(k);
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (isFull()) return false;
        front = front == 0 ? size - 1 : front - 1;
        mydeque[front] = value;
        count++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (isFull()) return false;
        mydeque[rear] = value;
        rear = (rear + 1) % size;
        count++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (isEmpty()) return false;        
        front = (front + 1) % size;
        count--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (isEmpty()) return false;
        rear = rear == 0 ? size - 1 : rear - 1;
        count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    int getFront() {
        if (isEmpty()) return -1;
        return mydeque[front];
    }
    
    /** Get the last item from the deque. */
    int getRear() {
        if (isEmpty()) return -1;
        return rear == 0 ? mydeque[size - 1] : mydeque[rear - 1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return count == size;
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */
// @lc code=end

