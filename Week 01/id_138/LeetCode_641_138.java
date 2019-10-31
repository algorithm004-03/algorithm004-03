/**
 * 设计双端队列
 * @author Lukas
 * @since 2019/10/19 20:36
 **/
public class LeetCode_641_138 {

    /**
     * 双链表
     */
    class CircleListNode {
        CircleListNode pre;
        CircleListNode next;
        int val;

        public CircleListNode(int v) {
            this.val = v;
        }
    }

    /**
     * 双端队列
     */
    class MyCircularDeque {
        int size;//队列当前元素个数
        int length;//队列初始化大小
        CircleListNode head;//队列头
        CircleListNode tail;//队列尾

        /** Initialize your data structure here. Set the size of the deque to be k. */
        public MyCircularDeque(int k) {
            head = new CircleListNode(-1);
            tail = new CircleListNode(-1);
            head.pre = tail;
            tail.next = head;
            this.size = 0;
            this.length = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (size == length) {
                return false;
            }
            CircleListNode node = new CircleListNode(value);
            node.next = head;
            node.pre = head.pre;
            head.pre.next = node;
            head.pre = node;
            size++;
            return true;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (size == length) {
                return false;
            }
            CircleListNode node = new CircleListNode(value);
            node.next = tail.next;
            tail.next.pre = node;
            tail.next = node;
            node.pre = tail;
            size++;
            return true;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (size == 0) {
                return false;
            }
            head.pre.pre.next = head;
            head.pre = head.pre.pre;
            size--;
            return true;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (size == 0)
                return false;
            tail.next.next.pre = tail;
            tail.next = tail.next.next;
            size--;
            return true;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return head.pre.val;
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return tail.next.val;
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return size==0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return size == length;
        }
    }
}
