#
# @lc app=leetcode id=144 lang=python3
#
# [144] Binary Tree Preorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
from collections import deque
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        ret = []
        stack = deque([None])
        while root:
            ret.append(root.val)
            if root.right:
                stack.append(root.right)
            if root.left:
                root = root.left
            else:
                root = stack.pop()
        return ret
        
# @lc code=end

