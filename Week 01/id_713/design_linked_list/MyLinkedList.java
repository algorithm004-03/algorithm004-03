/**
 * 自己实现的LinkedList
 */
class MyLinkedList {

    // 头指针
    private Node head = null;
    // 容量
    private int size = 0;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        Node node = this.getNode(index);
        if (node == null) return -1;
        return node.value;
    }

    /**
     * 扩展: 获取第N个节点的对象, 不仅是获取值
     *
     * @param index 索引
     * @return Node节点对象
     */
    public Node getNode(int index) {
        if (index > size - 1 || index < 0) return null;
        Node cur = head;
        while (index > 0) {
            if (cur == null) return null;
            cur = cur.next;
            index--;
        }
        return cur;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node newHead = new Node(val, head);
        head = newHead;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node tail = this.getNode(size - 1);
        Node newTail = new Node(val, null);
        tail.next = newTail;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        Node cur = this.getNode(index);
        Node pre = this.getNode(index - 1);

        Node newNode = new Node(val, cur);
        pre.next = newNode;

        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index > size - 1 || index < 0) return;
        Node cur = this.getNode(index);
        Node pre = this.getNode(index - 1);
        if (cur == null) return;

        if (cur == head) {
            head = cur.next;
        } else {
            pre.next = cur.next;
        }
        size--;

    }
}

class Node {
    int value;
    Node next;

    public Node() {
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
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