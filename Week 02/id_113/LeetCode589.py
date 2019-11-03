"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        traverse_path = []

        if root is None:
            return []

        traverse_path.append(root.val)
        for children in root.children:
            traverse_path.extend(self.preorder(children))

        return traverse_path