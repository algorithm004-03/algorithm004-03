class Solution {

private:
    int _min(int num1, int num2) {
        return (num1 < num2) ? num1 : num2;
    }

public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* head_ptr = nullptr;
        ListNode* tail_ptr = nullptr;
        ListNode* new_node_ptr = nullptr;

        ListNode* pos1_ptr = l1;
        ListNode* pos2_ptr = l2;

        while (! ( (pos1_ptr == nullptr) && (pos2_ptr == nullptr) ) ) {
            if ((pos1_ptr != nullptr) && (pos2_ptr != nullptr)) {
                new_node_ptr = new ListNode(_min(pos1_ptr->val, pos2_ptr->val));
                if (pos1_ptr->val <= pos2_ptr->val) {
                    pos1_ptr = pos1_ptr->next;
                } else {
                    pos2_ptr = pos2_ptr->next;
                }
            } else if (pos1_ptr != nullptr) {
                new_node_ptr = new ListNode(pos1_ptr->val);
                pos1_ptr = pos1_ptr->next;
            } else {
                new_node_ptr = new ListNode(pos2_ptr->val);
                pos2_ptr = pos2_ptr->next;
            }

            if (!head_ptr) {
                tail_ptr = head_ptr = new_node_ptr;
            } else {
                tail_ptr->next = new_node_ptr;
                tail_ptr = new_node_ptr;
            }
        }

        return head_ptr;
    }
};