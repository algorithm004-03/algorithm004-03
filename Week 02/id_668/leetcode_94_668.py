#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: inorder.py
    @time: 2019/10/23 20:45
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    """
        94. 给定一个二叉树，返回它的中序 遍历。

        示例:

        输入: [1,null,2,3]
           1
            \
             2
            /
           3

        输出: [1,3,2]

        分析：
        树的中序遍历的顺序为：左根右
    """

    def inorder_traversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]

        直接使用递归，从根节点开始遍历的顺序为左根右，假定当前层左子树、右子树均完成遍历，
        则此时对于根节点来说遍历的顺序就为左节点、根节点、右节点。左子树、右子树中任意节点均与根节点具有相同的遍历规律
        因为树种每个节点都要被访问两遍，因此时间复杂度为O(n)，空间上如果除了子节点外所有结点都具有左、右子节点，则空间复杂度为
        O(n)，平均下来为O(logn)

        时间复杂度：O(n)
        空间复杂度：O(logn)
        """
        orders = []

        def inorder(node):
            if node:
                inorder(node.left)
                orders.append(node.val)
                inorder(node.right)

        inorder(root)

        return orders

    def inorder_traversal2(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]

        这个解法其实是剖析递归实现的一种方法，用stack来存储访问到的但还未被处理的节点。首先中序遍历左根右的顺序，任意一节点
        首先都需要先访问左节点，直到这个节点没有左节点为止，然后处理这个节点，最后再处理这个节点的右节点，当然处理右节点的规则
        还是参照左根右的顺序，一直往下找下去，直到处理完所有的节点。

        时间复杂度：O(n)
        空间复杂度：最坏O(n)，平均O(logn)，这点的判断与leetcode官方题解不一样
        """
        res, stack = [], []
        cur = root

        while cur or len(stack) != 0:
            while cur:
                '''
                    对一节点执行左根右的遍历，其实就是不断地去寻找节点的左子结点，左子子节点...
                '''
                stack.append(cur)
                cur = cur.left

            cur = stack.pop()
            res.append(cur.val)
            cur = cur.right

        return res

