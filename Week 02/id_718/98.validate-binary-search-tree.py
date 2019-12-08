#
# @lc app=leetcode id=98 lang=python3
#
# [98] Validate Binary Search Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        return self.helper(root, float('inf'), float('-inf'))

    def helper(self, root, maxv, minv):
        if not root:
            return True
        if root.val >= maxv or root.val <= minv: 
            return False
        return  self.helper(root.left, root.val, minv) and self.helper(root.right, maxv, root.val)

'''
class Solution:
    def isValidBST(self, root: TreeNode) -> bool:
        def _isValid(root, maxv, minv):
            if not root:
                return True
            if root.val >= maxv or root.val <= minv:
                return False
            return _isValid(root.left, root.val, minv) and _isValid(root.right, maxv, root.val)
        return _isValid(root, float('inf'), float('-inf'))
'''
# @lc code=end

