class Node {
    int val;
    Node *prev_ptr;
    Node *next_ptr;

public:
    Node(int val) : val(val), prev_ptr(nullptr), next_ptr(nullptr) {}

    friend class MyCircularDeque;
};

class MyCircularDeque {
private:
    int curSize;
    Node *head_ptr;
    Node *tail_ptr;
    const int MAX_SIZE;

public:
    /** Initialize your data structure here. Set the size of the deque to be k. */
    MyCircularDeque(int k) : curSize(0), head_ptr(nullptr), tail_ptr(nullptr), MAX_SIZE(k) {

    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    bool insertFront(int value) {
        if (curSize == MAX_SIZE) {
            return false;
        }

        Node *new_node_ptr = new Node(value);

        if (curSize == 0) {
            head_ptr = tail_ptr = new_node_ptr;
        } else {
            head_ptr->prev_ptr = new_node_ptr;
            new_node_ptr->next_ptr = head_ptr;
            head_ptr = new_node_ptr;
        }

        curSize++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    bool insertLast(int value) {
        if (curSize == MAX_SIZE) {
            return false;
        }

        Node *new_node_ptr = new Node(value);

        if (curSize == 0) {
            head_ptr = tail_ptr = new_node_ptr;
        } else {
            tail_ptr->next_ptr = new_node_ptr;
            new_node_ptr->prev_ptr = tail_ptr;
            tail_ptr = new_node_ptr;
        }

        curSize++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    bool deleteFront() {
        if (curSize == 0) {
            return false;
        }

        Node *del_ptr = head_ptr;
        head_ptr = head_ptr->next_ptr;
        if (head_ptr) {
            head_ptr->prev_ptr = nullptr;
        }

        delete del_ptr;
        del_ptr = nullptr;

        curSize--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    bool deleteLast() {
        if (curSize == 0) {
            return false;
        }

        Node *del_ptr = tail_ptr;
        tail_ptr = tail_ptr->prev_ptr;
        if (tail_ptr) {
            tail_ptr->next_ptr = nullptr;
        }

        curSize--;
        return true;
    }

    /** Get the front item from the deque. */
    int getFront() {
        if (curSize == 0) {
            return -1;
        }

        return head_ptr->val;
    }

    /** Get the last item from the deque. */
    int getRear() {
        if (curSize == 0) {
            return -1;
        }

        return tail_ptr->val;
    }

    /** Checks whether the circular deque is empty or not. */
    bool isEmpty() {
        return (curSize == 0);
    }

    /** Checks whether the circular deque is full or not. */
    bool isFull() {
        return (curSize == MAX_SIZE);
    }
};