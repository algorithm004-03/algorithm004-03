"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""


class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        traverse_path = []

        if root is None:
            return []

        for children in root.children:
            traverse_path.extend(self.postorder(children))
        traverse_path.append(root.val)

        return traverse_path