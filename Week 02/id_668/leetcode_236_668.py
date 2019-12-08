#!/usr/bin/env python
# -*- coding:utf-8 -*-

"""
    @file: lowest_common_ancestor.py
    @time: 2019/10/26 06:22
"""


# Definition for a binary tree node.
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution(object):
    """
        给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
        满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
        例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]

        示例 1:
        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
        输出: 3
        解释: 节点 5 和节点 1 的最近公共祖先是节点 3

        示例 2:
        输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
        输出: 5
        解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

        说明:
        所有节点的值都是唯一的。
        p、q 为不同节点且均存在于给定的二叉树中。


        分析：
        题意中说明一个节点可以是它自己的祖先，且节点p、q一定会存在最近公共节点。
        因此求解结点p与结点q的最近公共祖先的大概步骤为：
        1. 判断p与q是否存在父子关系，若存在则就找到了节点p与节点q的最近公共祖先
        2. 若不存在，则寻找p的父节点p->p，q的父节点q->q
        3. 判断p->p与q->q两个节点间是否有父子关系，若存在则结束求解，
        4. 若不存在，则将p->p当做p，q->q当做q，重复步骤2
        4. 这种思考思路是由底向上的思想，从具体的节点开始，然后向上寻找各节点的父节点作判断
        5. 问题的求解，要从root节点开始，由上往下判断
    """

    def lowest_common_ancestor(self, root, p, q):
        """
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """

        # 递归终止条件，当前结点如果为p或q，返回真值
        if not root or root == p or root == q:
            return root

        # 判断当前结点的左节点是否为p或q，判断当前结点的右节点是否为p或q
        left = self.lowest_common_ancestor(root.left, p, q)
        right = self.lowest_common_ancestor(root.right, p, q)

        if left and right:
            # 若p是左子节点，且q是右子节点，则当前结点满足条件
            return root

        return left or right

