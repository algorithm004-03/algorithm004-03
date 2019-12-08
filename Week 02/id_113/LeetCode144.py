# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        traverse_path = []
        if root is None:
            return []

        traverse_path.append(root.val)
        traverse_path.extend(self.preorderTraversal(root.left))
        traverse_path.extend(self.preorderTraversal(root.right))

        return traverse_path
