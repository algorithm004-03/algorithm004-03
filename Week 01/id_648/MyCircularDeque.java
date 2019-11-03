public class MyCircularDeque {
    private int[] myqueue;
    private int front;
    private int rear;
    int size;
    int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.myqueue=new int[k];
        this.front=0;
        this.size=0;
        this.rear=0;
        this.capacity=k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){return false;}
        front = (front+capacity-1)%capacity;
        myqueue[front]=value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){return false;}
        myqueue[rear] = value;
        rear = (rear+capacity+1)%capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
         if(rear==front&&size==0){return false;}
         front=(front+1)%capacity;
         size--;
         return true;
    }
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(rear==front&&size==0){return false;}
        rear=(rear-1+capacity)%capacity;
        size--;
        return true;
    }
    /** Get the front item from the deque. */
    public int getFront() {
      if(size==0&&(rear==front)){return -1;}
      return myqueue[front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(size==0&&(rear==front)){return -1;}
        return myqueue[(rear-1+capacity)%capacity];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size==0&&rear==front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size==capacity&&rear==front;
    }
}
