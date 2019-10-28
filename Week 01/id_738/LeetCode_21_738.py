# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        # 递归法
        if not l1:
            return l2
        elif not l2:
            return l1
        else:
            if l1.val < l2.val:
                l1.next = self.mergeTwoLists(l1.next, l2)
                return l1
            else:
                l2.next = self.mergeTwoLists(l1, l2.next)
                return l2
        
        
        
        # 迭代法，时间复杂度O(n + m), 空间复杂度O(1)
        # prev = head = ListNode(0)
        # prev.next = l1
        # cur_1 = l1
        # cur_2 = l2
        # while cur_1 and cur_2:
        #     if cur_1.val <= cur_2.val:
        #         prev = cur_1
        #         cur_1 = cur_1.next
        #     else:
        #         prev.next = cur_2
        #         tmp = cur_2.next
        #         cur_2.next = cur_1
        #         prev = prev.next
        #         cur_2 = tmp
        # if not cur_1:
        #     prev.next = cur_2
        # return head.next



        