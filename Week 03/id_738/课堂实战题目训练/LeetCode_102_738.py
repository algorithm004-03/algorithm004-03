# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        二叉树的层次遍历：https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description

        :type root: TreeNode
        :rtype: List[List[int]]
        """
        # BFS
        if not root:
            return []
        result = []
        queue = [root]
        while queue:
            cur = []
            while queue:
                cur.append(queue.pop(0))
            result.extend([[i.val for i in cur]])
            for n in cur:
                if n.left: queue.append(n.left)
                if n.right: queue.append(n.right)
        return result
            
        
        # DFS
        # def dfs(level, root):
        #     if not root:
        #         return
        #     if level == len(self.result):
        #         self.result.append([root.val])
        #     else:
        #         self.result[level].append(root.val)
        #     if root.left: dfs(level + 1, root.left)
        #     if root.right: dfs(level + 1, root.right)
    
        # self.result = []
        # dfs(0, root)
        # return self.result

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        