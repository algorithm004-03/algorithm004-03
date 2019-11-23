# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def largestValues(self, root):
        """
        在每个树行中找最大值：https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/#/description

        :type root: TreeNode
        :rtype: List[int]
        """
        # BFS
        if not root:
            return []
        result = []
        queue = [root]
        while queue:
            curs = []
            while queue:
                curs.append(queue.pop())
            result.append(max([cur.val for cur in curs]))
            for cur in curs:
                if cur.left: queue.append(cur.left)
                if cur.right: queue.append(cur.right)
        return result
        
        # DFS
        # def dfs(level, root):
        #     if not root:
        #         return
        #     if level == len(result): result.append(root.val)
        #     else: result[level] = max(result[level], root.val)
        #     if root.left: dfs(level + 1, root.left)
        #     if root.right: dfs(level + 1, root.right)
        # result = []
        # dfs(0, root)
        # return result

        
        
        
        
        
        
        
        
        
        
        