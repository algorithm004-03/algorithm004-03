
type MyCircularDeque struct {
    Size int
    Values []int
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
    return MyCircularDeque{Size:k}
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
    if (len(this.Values) == this.Size) {
        return false
    } 
    this.Values = append([]int{value}, this.Values...)
    return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
    if (len(this.Values) == this.Size) {
        return false
    } 
    this.Values = append(this.Values, value)
    return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
    if (len(this.Values) == 0) {
        return false
    } 
    this.Values = this.Values[1:]
    return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
    if (len(this.Values) == 0) {
        return false
    } 
    this.Values = this.Values[:len(this.Values)-1]
    return true
}

/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() int {
    if len(this.Values) == 0 {
        return -1
    }
    return this.Values[0]
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() int {
    if len(this.Values) == 0 {
        return -1
    }
    return this.Values[len(this.Values)-1]
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
    return len(this.Values) == 0
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
    return len(this.Values) == this.Size
}
