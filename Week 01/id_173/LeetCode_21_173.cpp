/*
 * 21. 合并两个有序链表
 */

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
            ListNode* tempHead = new ListNode(-1);
            ListNode* prev = tempHead;

            while(l1 && l2) {
                if(l1->val <= l2->val) {
                    prev->next = l1;
                    l1 = l1->next;
                }
                else {
                    prev->next = l2;
                    l2 = l2->next;
                }

                prev = prev->next;
            }
            
            prev->next = (l1==NULL)?l2:l1;

            return tempHead->next;
    }
};