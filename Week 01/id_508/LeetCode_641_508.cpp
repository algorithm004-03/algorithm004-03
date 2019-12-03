class MyCircularDeque {
public:
    int *array;
    int siz;
    int cap;
    int front;
    int last;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) {
        array = new int[k];
        cap = k;
        front = 0;
        siz = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if(siz<cap) {
            array[front--] = value;

            front = (front+cap) % cap;
            siz++;

            return true;
        } else return false;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if(siz<cap) {
            siz++;
            array[(front+siz)%cap] = value;

            return true;
        } else return false;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if(siz>0) {
            front++;
            front=front%cap;
            siz--;
            return true;
        } else return false;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
           if(siz>0) {
            siz--;

            return true;
        } else return false;
    }

    /** Get the front item from the deque. */
    int getFront() {
        if(siz>0) return array[(front+1)%cap];
        else return -1;
    }

    /** Get the last item from the deque. */
    int getRear() {
        if(siz>0) return array[(front+siz)%cap];
        else return -1;
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return siz?false:true;
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull() {

        return siz==cap?true:false;
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
