# Definition for a binary tree node.
from typing import List, Optional


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        """
        因为前序遍历 第一位就是总根元素，又因为没有重复的数值，所以从中序里找到根节点
        种根
        根节点的索引还代表，左子树有多少个节点，
        然后构造左右子树
        """
        # 判断有无中序遍历 list
        if not inorder:
            return None
        # 种根
        root_tree = TreeNode(root_index := preorder[0])
        # 分割点
        middle_index = inorder.index(root_index)
        # 左子树        第一个已经却认为根，所以从1开始   从前道中，不包中
        root_tree.left = self.buildTree(preorder[1:middle_index + 1], inorder[:middle_index])
        # 右子树        左之后                        从中到右，不包中
        root_tree.right = self.buildTree(preorder[middle_index + 1:], inorder[middle_index + 1:])
        return root_tree


s = Solution()
print(s.buildTree([3, 9, 20, 15, 7], [9, 3, 15, 20, 7]))
