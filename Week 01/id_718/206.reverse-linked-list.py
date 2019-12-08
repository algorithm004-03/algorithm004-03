#
# @lc app=leetcode id=206 lang=python3
#
# [206] Reverse Linked List
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        cur, prev = head, None
        while cur:
            cur.next, cur, prev = prev, cur.next, cur
        return prev

'''      
  class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        p, head = head, self.reverseList(head.next)
        p.next.next, p.next = p, None
        return head 
'''
# @lc code=end

