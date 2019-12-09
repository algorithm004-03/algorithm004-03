"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""

class Solution(object):
    def __init__(self):
        self.result = []
        
    def preorder(self, root):
        """
        N叉树的前序遍历：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/submissions/

        :type root: Node
        :rtype: List[int]
        """
        #递归
        # if root:
        #     self.result.append(root.val)
        #     for node in root.children:
        #         self.preorder(node)
        # return self.result
        
        #迭代
        if not root:
            return []
        stack = [root]
        while stack:
            e = stack.pop()
            self.result.append(e.val)
            #由于栈先入后出，所以这里必须从最后一个子节点开始入栈，才能保证子节点从0到N扫描
            stack.extend(e.children[::-1])
        return self.result
    
    
    
    
    
    
    
    
    
    
    