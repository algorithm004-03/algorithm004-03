"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
      result = []
      if root is None:
        return
      def _preorder(root):
        for child in root.children:
          result.append(child.val)
          _preorder(child)
      result.append(root.val)
      _preorder(root)
      return result
