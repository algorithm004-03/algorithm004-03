"""
第五题：144. 二叉树的前序遍历
https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
"""

"""
解法一：递归
"""
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        f = self.preorderTraversal
        return [root.val] + f(root.left) + f(root.right) if root else []