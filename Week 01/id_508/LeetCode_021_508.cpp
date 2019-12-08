class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode* left= l2;
        ListNode Head(-1);
        ListNode* cur = &Head;
        cur->next = l1;
        while(cur) {
            if(cur->next&&left&&cur->next->val<=left->val) {
                cur = cur->next;
            } else if(cur->next&&left) {
                ListNode *swap = cur->next;
                cur->next = left;
                cur = left;
                left = swap;
            } else if(cur->next) {
                cur = cur->next;
            } else {
                cur->next = left;
                left = nullptr;
                cur = cur->next;
            }
        }
        return Head.next;

    }
};
