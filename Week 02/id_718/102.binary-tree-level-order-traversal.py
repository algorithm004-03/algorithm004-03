#
# @lc app=leetcode id=102 lang=python3
#
# [102] Binary Tree Level Order Traversal
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
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        ret = []
        if not root:
            return ret
        queue = deque([root])
        while len(queue):
            level = []
            for _ in range(len(queue)):
                p = queue.popleft()
                level.append(p.val)
                if p.left:
                    queue.append(p.left)
                if p.right:
                    queue.append(p.right)
            ret.append(level)
        return ret
            
# @lc code=end

