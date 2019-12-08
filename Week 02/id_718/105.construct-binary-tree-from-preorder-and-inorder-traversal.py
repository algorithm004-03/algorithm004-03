#
# @lc app=leetcode id=105 lang=python3
#
# [105] Construct Binary Tree from Preorder and Inorder Traversal
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        if not inorder:
            return None
        root = TreeNode(preorder[0])
        rootPos = inorder.index(root.val)
        root.left = self.buildTree(preorder[1:1+rootPos], inorder[:rootPos])
        root.right = self.buildTree(preorder[1+rootPos:], inorder[rootPos+1:])
        return root
# @lc code=end

