package main

import "fmt"

type MyCircularDeque struct {
	cap int
	length int
	head *Node
	end *Node
}

type Node struct {
	value int
	pre *Node
	next *Node
}


/** Initialize your data structure here. Set the size of the deque to be k. */
func Constructor(k int) MyCircularDeque {
	deque := &MyCircularDeque{k, 0, nil, nil}

	return *deque
}


/** Adds an item at the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertFront(value int) bool {
	if this.IsFull() {
		return false
	}

	node := &Node{value:value}

	if this.length == 0 {
		this.head = node
		this.end = node
	} else {
		node.next = this.head
		this.head.pre = node
		this.head = node
	}

	this.length++

	return true
}


/** Adds an item at the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) InsertLast(value int) bool {
	if this.IsFull() {
		return false
	}

	node := &Node{value:value}
	if this.length == 0 {
		this.head = node
		this.end = node
	} else {
		node.pre = this.end
		this.end.next = node
		this.end = node
	}
	this.length++

	return true
}


/** Deletes an item from the front of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteFront() bool {
	if this.IsEmpty() {
		return false
	}

	if this.length == 1 {
		this.head = nil
		this.end = nil
	} else {
		this.head = this.head.next
		this.head.pre = nil
	}

	this.length--

	return true
}


/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
func (this *MyCircularDeque) DeleteLast() bool {
	if this.IsEmpty() {
		return false
	}

	if this.length == 1 {
		this.head = nil
		this.end = nil
	} else {
		this.end = this.end.pre
		this.end.next = nil
	}

	this.length--

	return true
}


/** Get the front item from the deque. */
func (this *MyCircularDeque) GetFront() interface{} {
	if this.head == nil {
		return -1
	}
	return this.head.value
}


/** Get the last item from the deque. */
func (this *MyCircularDeque) GetRear() interface{} {
	if this.end == nil {
		return -1
	}
	return this.end.value
}


/** Checks whether the circular deque is empty or not. */
func (this *MyCircularDeque) IsEmpty() bool {
	return this.length == 0
}


/** Checks whether the circular deque is full or not. */
func (this *MyCircularDeque) IsFull() bool {
	return  this.length == this.cap
}

func main()  {
	obj := Constructor(4)
	param1 := obj.InsertFront(9)
	param2 := obj.DeleteLast()
	param3 := obj.GetRear()
	param4 := obj.GetFront()
	param5 := obj.DeleteFront()
	param6 := obj.InsertFront(6)
	param7 := obj.InsertLast(5)
	param8 := obj.InsertFront(9)
	param9 := obj.GetFront()
	param10 := obj.InsertFront(6)


	fmt.Println(param1, param2, param3, param4, param5, param6, param7, param8, param9, param10)
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
