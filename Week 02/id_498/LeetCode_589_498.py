"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        list1 = []
        if root is None:
            return []
        list1.append(root.val)
        for i in root.children:
            list1 += self.preorder(i)
        return list1
