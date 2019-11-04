"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def postorder(self, root):
        """
        N叉树的后序遍历：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/

        :type root: Node
        :rtype: List[int]
        """

        #递归
        # if root:
        #     for node in root.children:
        #         self.postorder(node)
        #     self.result.append(root.val)
        # return self.result
    
        # 迭代
        if not root:
            return []
        stack = [root]
        while stack:
            e = stack.pop()
            self.result.append(e.val)
            if e.children:
                stack.extend(e.children)
        return self.result[::-1]