package leetcode

type MyCircularDeque struct {
	elements   []int
	frontIndex int
	rearIndex  int
}

/** Initialize your data structure here. Set the cap of the deque to be k. */
func Constructor(k int) MyCircularDeque {

	return MyCircularDeque{elements: make([]int, k+1), frontIndex: 0, rearIndex: 0}
}

/** Adds an item at the frontIndex of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {

	if this.IsFull() {

		return false
	}

	this.frontIndex = (this.frontIndex - 1 + len(this.elements)) % len(this.elements)
	this.elements[this.frontIndex] = value
	return true;
}

/** Adds an item at the rearIndex of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {

	if this.IsFull() {

		return false
	}
	this.elements[this.rearIndex] = value
	this.rearIndex = (this.rearIndex + 1) % len(this.elements)
	return true
}

/** Deletes an item from the frontIndex of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {

	if this.IsEmpty() {

		return false
	}

	this.frontIndex = (this.frontIndex + 1) % len(this.elements)
	return true
}

/** Deletes an item from the rearIndex of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {

	if this.IsEmpty() {

		return false
	}

	this.rearIndex = ((this.rearIndex - 1) + len(this.elements)) % len(this.elements)
	return true
}

/** Get the frontIndex item from the deque. */
func (this *MyCircularDeque) GetFront() int {

	if this.IsEmpty() {

		return -1
	}
	return this.elements[this.frontIndex]
}

/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {

	if this.IsEmpty() {

		return -1
	}
	return this.elements[(this.rearIndex-1+len(this.elements))%len(this.elements)]
}

/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {

	return this.frontIndex == this.rearIndex
}

/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {

	return (this.rearIndex+1)%len(this.elements) == this.frontIndex
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * obj := Constructor(k);
 * param_1 := obj.InsertFront(value);
 * param_2 := obj.InsertLast(value);
 * param_3 := obj.DeleteFront();
 * param_4 := obj.DeleteLast();
 * param_5 := obj.GetFront();
 * param_6 := obj.GetRear();
 * param_7 := obj.IsEmpty();
 * param_8 := obj.IsFull();
 */
//leetcode submit region end(Prohibit modification and deletion)
