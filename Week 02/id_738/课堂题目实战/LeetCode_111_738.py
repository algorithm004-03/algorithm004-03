# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def minDepth(self, root):
        """
        二叉树最小深度：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
        
        :type root: TreeNode
        :rtype: int
        """
        #递归:化解为求解左子树和右子树的较小深度的值
        #注意一点：如果节点没有左/右孩子中的一个，那么最小深度为节点的右/左孩子的深度+1.
#         if not root:
#             return 0
#         if root.left and root.right:
#             left_depth = self.minDepth(root.left)
#             right_depth = self.minDepth(root.right)
#             return min(left_depth, right_depth) + 1
#         if not root.left and not root.right:
#             return 1
#         if root.left:
#             return self.minDepth(root.left) + 1
#         if root.right:
#             return self.minDepth(root.right) + 1
        
        #迭代:不必对整棵树扫描，只需要扫描最近层的叶子节点的层数即是最小层。
        #所以用广度优先遍历，一层一层往下遍历。
        #数据结构用双端队列，本层节点放在队列左端，子节点往队列右端入队列，这样就会先扫描完本层节点再扫描下层节点了
        # if not root:
        #     return 0
        # from collections import deque
        # queue = deque([(root, 1)])
        # while queue:
        #     node, node_level = queue.popleft()
        #     if not node.left and not node.right:
        #         return node_level
        #     if node.left:
        #         queue.append((node.left, node_level + 1))
        #     if node.right:
        #         queue.append((node.right, node_level + 1))

        #迭代2：
        if not root: return 0
        queue = [root]
        level = 1
        while queue:
            v = []
            while queue:
                cur = queue.pop(0)
                if not cur.left and not cur.right:
                    return level
                v.append(cur)
            level += 1
            for cur in v:
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
            
        
        
        
        
        
        
        
        
        
        
        
        