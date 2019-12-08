class MyCircularDeque {
	
	private int[] data;
	private int head = 0, tail = 0, count = 0;
	
	/** Initialize your data structure here. Set the size of the deque to be k. */
	public MyCircularDeque(int k) {
		data = new int[k];
	}
	
	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (count >= data.length) return false;
		head = 0 == head?data.length - 1:head--;
		data[head] = value;
		count++;
		return true;
	}
	
	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (count >= data.length) return false;
		data[tail++] = value;
		tail %= data.length;
		count++;
		return true;
	}
	
	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (0 == count) return false;
		head++;
		head %= data.length;
		count--;
		return true;
	}
	
	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (0 == count) return false;
		tail = 0 == tail?data.length - 1:tail--;
		tail %= data.length;
		count--;
		return true;
	}
	
	/** Get the front item from the deque. */
	public int getFront() {
		if (0 == count) return -1;
		return data[head];
		
	}
	
	/** Get the last item from the deque. */
	public int getRear() {
		if (0 == count) return -1;
		return 0 == tail?data[data.length - 1]:data[tail - 1];
	}
	
	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return 0 == count;
	}
	
	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return count == data.length;
	}
}