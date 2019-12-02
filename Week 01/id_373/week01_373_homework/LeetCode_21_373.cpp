//3
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *prehead = new ListNode(-1);
	ListNode *prev = prehead;
	
	while (l1 != NULL && l2 != NULL) {
            if (l1->val <= l2->val) {
                prev->next = l1;
                l1 = l1->next;
            } else {
                prev->next = l2;
                l2 = l2->next;
            }
            prev = prev->next;
        }

        prev->next = l1 == NULL ? l2 : l1;

        return prehead->next;
    }
        
};