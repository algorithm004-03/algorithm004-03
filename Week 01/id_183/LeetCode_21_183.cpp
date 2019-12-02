/*
 * @lc app=leetcode id=21 lang=cpp
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        //recursive
        //always find a smaller head
        //always return head of list
        if(l1 == NULL)
            return l2;
        if(l2 == NULL)
            return l1;
        if(l1->val<l2->val)
        {
            l1->next = mergeTwoLists(l1->next,l2);
            return l1;
        }
        else{
            l2->next = mergeTwoLists( l2->next,l1);
            return l2;
        }
    }
};
// @lc code=end

