"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        stack = root and [root]
        while stack:
            top = stack.pop()
            res.append(top.val)
            stack += reversed(top.children)
        return res