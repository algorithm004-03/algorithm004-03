#
# @lc app=leetcode id=145 lang=python3
#
# [145] Binary Tree Postorder Traversal
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
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        ret = []
        if not root:
            return ret
        stack = deque([root])
        pre = None
        while len(stack):
            p = stack[-1]
            if (p.left is None and p.right is None) or (pre and (pre == p.left or pre == p.right)):
                ret.append(p.val)
                stack.pop()
                pre = p
            else:
                if p.right: stack.append(p.right)
                if p.left: stack.append(p.left)
        return ret
# @lc code=end

