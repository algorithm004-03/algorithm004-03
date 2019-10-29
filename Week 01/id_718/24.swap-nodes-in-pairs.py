#
# @lc app=leetcode id=24 lang=python3
#
# [24] Swap Nodes in Pairs
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        self.next = head
        prev, cur = self, head
        while cur and cur.next:
            next = cur.next
            cur.next = cur.next.next
            next.next = prev.next
            prev.next = next
            # move
            prev, cur = cur, prev.next
        return self.next
        
# @lc code=end

