"""
第四题：94. 二叉树的中序遍历
https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
"""

"""
解法一：使用递归求解
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution_1:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        f = self.inorderTraversal
        return f(root.left) + [root.val] + f(root.right) if root else []



"""
解法二：
使用迭代求解
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution_2:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return res
        stack = [root]
        while stack:
            node = stack.pop()
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
            res.append(node.val)
        return res[::-1]