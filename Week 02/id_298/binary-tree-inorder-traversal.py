# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
      result = []
      def _inorderTraversal(root):
        if root is None:
          return
        _inorderTraversal(root.left)
        result.append(root.val)
        _inorderTraversal(root.right)
      _inorderTraversal(root)
      return result
