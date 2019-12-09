# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        二叉树的最大深度：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/

        :type root: TreeNode
        :rtype: int
        """
        # 递归
        # def depth(cur):
        #     if not cur:
        #         return 0
        #     left_level = depth(cur.left)
        #     right_level = depth(cur.right)
        #     return max(left_level, right_level) + 1
        # return depth(root)
    
        #迭代：利用一个stack和一个数组，stack维护二叉树下一层的节点，list维护当前层的节点
        #操作：每到一层，清空stack的数据到list中，并循环list的元素，探索其直接子节点，全部入stack
        #如果操作后stack不为空，则表示下一层还有节点,level+=1。否则结束循环，返回level
        # if not root:
        #     return 0
        # stack = [root]
        # cur_level_nodes = []
        # level = 1
        # while stack:
        #     while stack:
        #         cur_level_nodes.append(stack.pop())
        #     for node in cur_level_nodes:
        #         if node.left:
        #             stack.append(node.left)
        #         if node.right:
        #             stack.append(node.right)
        #     if stack:
        #         level += 1
        #     cur_level_nodes = []
        # return level
        
        #迭代2：迭代1维护了2个列表。如果用一个列表，那么列表存储除了节点还要存储节点所在的层数。比如root就存为(root, 1)
        if not root:
            return 0
        stack = [(root, 1)]
        level = 1
        while stack:
            cur, cur_depth = stack.pop()
            if level < cur_depth:
                level = cur_depth
            if cur.left:
                stack.append((cur.left, cur_depth + 1))
            if cur.right:
                stack.append((cur.right, cur_depth + 1))
        return level








                




                
