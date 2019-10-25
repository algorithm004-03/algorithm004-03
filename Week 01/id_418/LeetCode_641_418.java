package com.ljg.leetcode.a_008.deque;

/**
 * MyCircularDeque 设计实现双端队列。 你的实现需要支持以下操作：
 * 
 * MyCircularDeque(k)：构造函数,双端队列的大小为k。
 * 
 * insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回true。
 * 
 * insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 * 
 * deleteFront()：从双端队列头部删除一个元素。如果操作成功返回 true。
 * 
 * deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 * 
 * getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 * 
 * getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回-1。
 * 
 * isEmpty()：检查双端队列是否为空。
 * 
 * isFull()：检查双端队列是否满了。
 * 
 * 示例：
 * 
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * 
 * circularDeque.insertLast(1); // 返回 true
 * 
 * circularDeque.insertLast(2); // 返回true
 * 
 * circularDeque.insertFront(3); // 返回 true
 * 
 * circularDeque.insertFront(4); //已经满了，返回 false
 * 
 * circularDeque.getRear(); // 返回 2
 * 
 * circularDeque.isFull(); // 返回 true
 * 
 * circularDeque.deleteLast(); // 返回 true
 * 
 * circularDeque.insertFront(4); //返回 true
 * 
 * circularDeque.getFront(); // 返回 4
 * 
 * 提示：
 * 
 * 所有值的范围为 [1, 1000]
 * 
 * 操作次数的范围为 [1, 1000]
 * 
 * 请不要使用内置的双端队列库
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/design-circular-deque
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyCircularDeque {

    private int modCount;

    private int size;

    private int elementCount;

    private Node first;

    private Node last;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        modCount = 0;
        size = k;
        elementCount = 0;

        first = null;
        last = null;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {

        try {
            validModCount();

            validRange(value);
        } catch (Exception e) {
            return false;
        }
        

        if (elementCount >= size) {
            return false;
        }

        return linkFirst(value);
    }

    private boolean linkFirst(int value) {
        Node temp = first;
        Node node = new Node(null, temp, value);
        first = node;
        if (temp == null) {
            last = node;
        } else {
            temp.pre = node;
        }
        elementCount++;
        modCount++;

        return true;
    }

    private boolean linkLast(int value) {
        Node temp = last;
        Node node = new Node(temp, null, value);
        last = node;
        if (temp == null) {
            first = node;
        } else {
            temp.next = node;
        }
        elementCount++;
        modCount++;
        return true;
    }

    private boolean unLinkFirst() {
        if (first == null) {
            return false;
        }

        Node temp = first.next;
        if (temp == null) {
            last = null;
        } else {
            temp.pre = null;
        }
        first = temp;

        modCount++;
        elementCount--;

        return true;
    }

    private boolean unLinkLast() {
        if (last == null) {
            return false;
        }

        Node temp = last.pre;
        if (temp == null) {
            first = null;
        } else {
            temp.next = null;
        }
        last = temp;

        modCount++;
        elementCount--;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {

        try {
            validModCount();

            validRange(value);
        } catch (Exception e) {
            return false;
        }

        if (elementCount >= size) {
            return false;
        }

        return linkLast(value);

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        try {
            validModCount();

        } catch (Exception e) {
            return false;
        }

        return unLinkFirst();
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        try {
            validModCount();

        } catch (Exception e) {
            return false;
        }

        return unLinkLast();
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (elementCount == 0) {
            return -1;
        }

        return first.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (elementCount == 0) {
            return -1;
        }

        return last.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return elementCount == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return elementCount == size;
    }

    private void validRange(int value) {
        // if (value < 1 || value > 1000) {
        //     throw new RuntimeException("value must not greater than and lesser than 1");
        // }
    }

    private void validModCount() {
        if (modCount < 0 || modCount > 1000) {
            throw new RuntimeException("modCount must not greater than and lesser than 0");
        }
    }

    private static class Node {
        private Node pre;
        private Node next;
        private int value;

        Node(Node pre, Node next, int value) {
            this.pre = pre;
            this.next = next;
            this.value = value;
        }
    }

    public static void main(String[] args) {

        // Your MyCircularDeque object will be instantiated and called as such:
        // MyCircularDeque circularDeque = new MyCircularDeque(3); // 设置容量大小为3
        // System.out.println();
        // System.out.println(circularDeque.insertLast(1)); // 返回 true
        // System.out.println(circularDeque.insertLast(2)); // 返回 true
        // System.out.println(circularDeque.insertFront(3)); // 返回 true
        // System.out.println(circularDeque.insertFront(4)); // 已经满了，返回 false
        // System.out.println(circularDeque.getRear()); // 返回 2
        // System.out.println(circularDeque.isFull()); // 返回 true
        // System.out.println(circularDeque.deleteLast()); // 返回 true
        // System.out.println(circularDeque.insertFront(4)); // 返回 true
        // System.out.println(circularDeque.getFront()); // 返回 4
        // System.out.println(circularDeque.getRear());
        // System.out.println(circularDeque.deleteLast());
        // System.out.println(circularDeque.insertLast(0));
        // System.out.println(circularDeque.getRear());

        MyCircularDeque circularDeque = new MyCircularDeque(5); // 设置容量大小为3
        System.out.println();
        System.out.println(circularDeque.insertFront(7));
        System.out.println(circularDeque.insertLast(0)); 
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.insertLast(3));
        System.out.println(circularDeque.getFront()); 
        System.out.println(circularDeque.insertFront(9));
        System.out.println(circularDeque.getRear());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.getFront());
        System.out.println(circularDeque.deleteLast());
        System.out.println(circularDeque.getRear());

//         ["MyCircularDeque","insertFront","insertLast","getFront","insertLast","getFront","insertFront","getRear","getFront","getFront","deleteLast","getRear"]
// [[5],[7],[0],[],[3],[],[9],[],[],[],[],[]]

// [null,true,false,7,true,7,true,3,9,9,true,7]
// [null,true,true,7,true,7,true,3,9,9,true,0]
    }
}