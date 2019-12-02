package id313

// 插入和删除都在尾部，查询也在头部和尾部 所以使用双链表实现效率会比使用数组高
type node struct {
	val  int
	prev *node
	next *node
}

type MyCircularDeque struct {
	front *node
	rear  *node
	cap   int
	size  int
}

// Constructor Initialize your data structure here. Set the size of the deque to be k.
func Constructor(k int) MyCircularDeque {
	return MyCircularDeque{front: &node{}, rear: &node{}, size: 0, cap: k}
}

/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.size == this.cap {
		return false
	}
	if 0 == this.size {
		this.front = &node{val: value}
		this.rear = this.front
	} else {
		front := this.front
		this.front = &node{val: value, next: front}
		front.prev = this.front
	}
	this.size++
	return true
}

/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.size == this.cap {
		return false
	}
	if 0 == this.size {
		this.front = &node{val: value}
		this.rear = this.front
	} else {
		rear := this.rear
		this.rear = &node{val: value, prev: rear}
		rear.next = this.rear
	}
	this.size++
	return true
}

/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if 0 == this.size {
		return false
	}
	next := this.front.next
	if nil == next {
		this.front = nil
		this.rear = nil
	} else {
		this.front = next
		this.front.prev = nil
	}
	this.size--
	return true
}

/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if 0 == this.size {
		return false
	}
	prev := this.rear.prev
	if nil == prev {
		this.rear = nil
		this.front = nil
	} else {
		this.rear = prev
		this.rear.next = nil
	}
	this.size--
	return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
	if 0 == this.size {
		return -1
	}
	return this.front.val
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
	if 0 == this.size {
		return -1
	}
	return this.rear.val
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return 0 == this.size
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return this.size == this.cap
}
