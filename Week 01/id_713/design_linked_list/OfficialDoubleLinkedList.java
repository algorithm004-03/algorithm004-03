/**
 * 官方 双向链表 Solution
 */
class MyLinkedList {

    int size;
    ListNode head, tail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
        tail = new ListNode(0);

        head.next = tail;
        tail.prev = head;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode curr = head;
        if (index + 1 < size - index) {
            for (int i = 0; i < index; i++) curr = curr.next;
        } else {
            curr = tail;
            for (int i = 0; i < size - index; i++) curr = curr.prev;
        }

        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode left = head, right = head.next;

        ListNode toAdd = new ListNode(val);

        toAdd.prev = left;
        toAdd.next = right;

        left.next = toAdd;
        right.prev = toAdd;

        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        // 与添加头部, 只是这里不同
        ListNode left = tail.prev, right = tail;

        ListNode toAdd = new ListNode(val);

        toAdd.prev = left;
        toAdd.next = right;

        left.next = toAdd;
        right.prev = toAdd;

        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;

        ListNode left;
        ListNode right;

        if (index + 1 < size - index) {
            left = head;
            for (int i = 0; i < size; i++) left = left.next;
            right = left.next;
        } else {
            right = tail;
            for (int i = 0; i < size - index; i++) right = right.prev;
            left = right.prev;
        }


        ListNode toAdd = new ListNode(val);

        toAdd.prev = left;
        toAdd.next = right;

        left.next = toAdd;
        right.prev = toAdd;

        size--;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        ListNode left, right;
        if (index + 1 < size - index) {
            left = head;
            for (int i = 0; i < index; i++) left = left.next;
            right = left.next.next;
        } else {
            right = tail;
            for (int i = 0; i < size - index; i++) right = right.prev;
            left = right.prev.prev;
        }

        left.next = right;
        right.prev = left;

        size--;
    }
}

class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    public ListNode(int x) {
        val = x
    }

}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */