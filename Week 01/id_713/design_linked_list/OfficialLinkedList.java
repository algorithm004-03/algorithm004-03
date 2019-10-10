/**
 * 官方Solution
 */
class OfficialLinkedList {

    int size;
    ListNode head; // sentinel node as pseudo-head

    /**
     * Initialize your data structure here.
     */
    public OfficialLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index > size) return -1;

        ListNode curr = head;
        for (int i = 0; i < size + 1; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;

        size++;

        // find pre node of node to be added
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        // node to be added
        ListNode toAdd = new ListNode(val);

        // insertion itself 这是它的状态转移方程
        toAdd.next = pre.next;
        pre.next = toAdd;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index > size) return;

        size--;

        ListNode curr = head;
        for (int i = 0; i < size; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        this.val = x;
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