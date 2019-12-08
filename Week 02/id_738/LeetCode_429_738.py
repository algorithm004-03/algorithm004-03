"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def levelOrder(self, root):
        """
        N叉树的层序遍历：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/

        :type root: Node
        :rtype: List[List[int]]
        """
        if not root:
            return []
        queue = [root]
        result = []
        while queue:
            t = []
            children = []
            for i in queue:
                t.append(i.val)
                children += i.children
            result.append(t)
            queue = children
        return result
        

        