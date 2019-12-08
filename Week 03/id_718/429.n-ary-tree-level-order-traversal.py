#
# @lc app=leetcode id=429 lang=python3
#
# [429] N-ary Tree Level Order Traversal
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        ret = []
        if not root:
            return ret
        q = [root]
        while len(q):
            n, level = len(q), []
            for _ in range(n):
                node = q.pop(0)
                level.append(node.val)
                for c in node.children:
                    q.append(c)
            ret.append(level)
        return ret
# @lc code=end

