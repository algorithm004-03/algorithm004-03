#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: binary_tree_level_order_traversal.py
    @time: 2019/10/29 21:26
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    """
        给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

        例如:
        给定二叉树: [3,9,20,null,null,15,7],

            3
           / \
          9  20
            /  \
           15   7
        返回其层次遍历结果：

        [
          [3],
          [9,20],
          [15,7]
        ]
    """

    def level_order(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        levels = []

        if not root:
            return levels

        def helper(node, level):
            if len(levels) == level:
                '''
                    level层从0开始计数，而levels存储每一层的结点值，因此这里很巧妙的处理是依据当前
                    levels中元素的个数判断是否需要添加新的一层；比如个数为0，表示正处理第0层，个数为3
                    表示正处理第3层。
                '''
                levels.append([])

            levels[level].append(node.val)

            if node.left:
                helper(node.left, level + 1)

            if node.right:
                helper(node.right, level + 1)

        helper(root, 0)

        return levels

    def level_order2(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []

        # level表示这一层装了多少个节点
        ans, level = [], [root]

        while level:
            ans.append([node.val for node in level])
            temp = []

            for node in level:
                temp.extend([node.left, node.right])

            level = [leaf for leaf in temp if leaf]

        return ans

    def level_order3(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        if not root:
            return []

        res, level = [], [root]  # 起始层为根节点所在的层

        # level表示当前层里存储的节点，当当前层不存在结点时，处理结束
        while level:
            res.append([node.val for node in level])
            level = [kid for node in level for kid in (node.left, node.right) if kid]

        return res

