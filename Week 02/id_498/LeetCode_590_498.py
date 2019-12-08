"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        list1 = []
        if root is None:
            return []
        for i in root.children:
            list1 += self.postorder(i)
        list1.append(root.val)
        return list1
