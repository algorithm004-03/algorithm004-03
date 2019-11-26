//641. 循环双向队列

//解法1 双向链表解法
//自己一开始采用的是数组解法，然后死活通过不了，看了下外国网站的大神用双向链表的实现，十分简单直观..
public class MyCircularDeque {
    int size;
    int k;
    DoubleListNode head;
    DoubleListNode tail;

    public MyCircularDeque(int k) {
        this.k = k;
        this.size = 0;
        head = new DoubleListNode(-1);
        tail = new DoubleListNode(-1);
        head.prev = tail;
        tail.next = head;
    }

    public boolean insertFront(int value) {
        if (size == k) {
            //queue已满
            return false;
        }
        DoubleListNode node = new DoubleListNode(value);
        DoubleListNode prevNode = head.prev;
        node.next = head;
        node.prev = prevNode;
        prevNode.next = node;
        head.prev = node;
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (size == k) {
            return false;
        }
        DoubleListNode node = new DoubleListNode(value);
        DoubleListNode nextNode = tail.next;
        node.prev = tail;
        tail.next = node;
        nextNode.prev = node;
        node.next = nextNode;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (size == 0) {
           return false;
        }
        DoubleListNode prevNode = head.prev.prev;
        prevNode.next = head;
        head.prev = prevNode;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        DoubleListNode nextNode = tail.next.next;
        tail.next = nextNode;
        nextNode.prev = tail;
        size--;
        return true;
    }

    public int getFront() {
        return head.prev.data;
    }

    public int getRear() {
        return tail.next.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

}

class DoubleListNode {
    DoubleListNode prev;
    DoubleListNode next;
    int data;

    public DoubleListNode (int data) {
        this.data = data;
    }
}