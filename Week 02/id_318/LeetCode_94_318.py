# 94. Binary Tree Inorder Traversal

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        def wrapper(root):
            if not root:
                return 
            wrapper(root.left)
            res.append(root.val)
            wrapper(root.right)
        wrapper(root)
        return res
