#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: merge_two_sorted_list.py
    @time: 2019/10/18 07:58
"""


# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    """
        将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

        示例：
        输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4

        分析：因为合并的是两个有序链表，所以很容易想到从头至尾一个一个的比较两个链表中的元素，然后
        将其串起来即可。觉得这里题意说的有序应该特指一下两个链表具有相同的顺序，如果一个升序，一个
        降序，则需要处理一下。另外这里引入一个哨兵结点dummy，用于后面的处理具有一致性。
    """

    def merge_two_lists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode

        最少需要遍历的元素个数为min(len_of_l1, len_of_l2)，
        最多的元素个数为len_of_l1 + len_of_l2，空间使用上可忽略不计
        时间复杂度：O(min(l1, l2)) ~ O(l1 + l2)
        空间复杂度：O(1)
        """
        dummy = cur = ListNode(0)

        while l1 and l2:
            if l1.val <= l2.val:
                cur.next, cur = l1, l1
                l1 = l1.next
            else:
                cur.next, cur = l2, l2
                l2 = l2.next

        cur.next = l1 if l1 else l2

        return dummy.next

