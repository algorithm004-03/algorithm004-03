# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
      result = []
      def _preorderTraversal(root):
        if root is None:
          return
        result.append(root.val)
        _preorderTraversal(root.left)
        _preorderTraversal(root.right)
      _preorderTraversal(root)
      return result
