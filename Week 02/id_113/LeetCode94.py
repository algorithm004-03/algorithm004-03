# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        traverse_path = []
        if root is None:
            return []

        traverse_path += self.inorderTraversal(root.left)
        traverse_path.append(root.val)
        traverse_path += self.inorderTraversal(root.right)

        return traverse_path