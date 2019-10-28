/**
 * 题目: 设计循环双端队列
 * 思路: Javascript中无论使用何种方式创建数组,都会动态分配内存空间,不存在溢出等问题,因此我们通常使用数组来实现栈/各种队列
 */

/**
 * Initialize your data structure here. Set the size of the deque to be k.
 * @param {number} k
 */
class MyCircularDeque{
    constructor(size){
        this.queue = [];
        this.size = size;
    }

    insertFront(k) {
        if(this.isFull()) return false;
        this.queue.unshift(k);
        return true;
    }

    insertLast(k) {
        if(this.isFull()) return false;
        this.queue.push(k);
        return true;
    }

    deleteFront() {
        if(this.isEmpty()) return false;
        this.queue.shift();
        return true;
    }

    deleteLast() {
        if(this.isEmpty()) return false;
        this.queue.pop();
        return true;
    }

    getFront() {
        return this.isEmpty() ? -1 : this.queue[0];
    }

    getRear() {
        return this.isEmpty() ? -1 : this.queue[this.queue.length -1];
    }

    isEmpty() {
        return this.queue.length === 0;
    }

    isFull() {
        return this.queue.length === this.size;
    }
}