# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def invertTree(self, root):
        """
        翻转二叉树: https://leetcode-cn.com/problems/invert-binary-tree/submissions/

        :type root: TreeNode
        :rtype: TreeNode
        """
        #递归
        # if root:
        #     root.left, root.right = root.right, root.left
        #     self.invertTree(root.left)
        #     self.invertTree(root.right)
        #     return root
            
        #迭代
        if not root:
            return root
        stack = [root]
        e = root
        while stack:
            e = stack.pop()
            e.left, e.right = e.right, e.left
            if e.left:
                stack.append(e.left)
            if e.right:
                stack.append(e.right)
        return root
        
        
        