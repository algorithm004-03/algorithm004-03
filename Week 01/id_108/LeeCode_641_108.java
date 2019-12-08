package study;

public class LeeCode_641_108 {


    private int[] nums;     // 定义一个顺序队列，用数组来存储队列元素
    private int count = 0;  // count 来表示队列中当前存在的元素个数
    private int head = 0;  // head 表示队列的头
    private int tail =0;   // tail 表示队列的尾

    public LeeCode_641_108(int k) {
        nums =  new int[k]; // 根据 k 来初始化数组的长度
    }
    
    
    public boolean insertFront(int value) {
        if(count>=nums.length) return false; // 队列元素个数超出数组长度则无法再入队
        if(head==0)
            head=nums.length-1;
        else
            head-=1;
        nums[head] = value; // 队列未满则将元素入队，尾指针以及数组元素 +1
        count++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count>=nums.length) return false; // 队列元素个数超出数组长度则无法再入队
        nums[tail++] = value; // 队列未满则将元素入队，尾指针以及数组元素 +1
        count++;
        tail = tail % nums.length;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count==0) return false; // 队列为空则无法删除元素
        head++;
        head = head % nums.length; // 减少数组搬运操作直接将队列头移向下一元素
        count--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count==0) return false; // 队列为空则无法删除元素
        if(tail==0)
            tail=nums.length-1; // 减少数组搬运操作直接将队列尾移向上一元素
        else
            tail-=1;
        count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(count==0) return -1;
        return nums[head]; 
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(count==0) return -1;
        if(tail==0) return nums[nums.length-1];
        return nums[tail-1];
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == nums.length;
    }
    
    
    public static void main(String args[]){
    	LeeCode_641_108 circularDeque = new LeeCode_641_108(8);
    	boolean param_1 = circularDeque.insertFront(8);
    	boolean param_2 = circularDeque.insertLast(7);
    	boolean param_3 = circularDeque.deleteFront();
    	boolean param_4 = circularDeque.deleteLast();
    	int param_5 = circularDeque.getFront();
    	int param_6 = circularDeque.getRear();
    	boolean param_7 = circularDeque.isEmpty();
    	boolean param_8 = circularDeque.isFull();
    	
    	//System.out.println("param_5"+param_5.);
    }


}
