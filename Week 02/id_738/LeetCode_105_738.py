# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        从前序与中序遍历序列构造二叉树: https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        
        #解法步骤：
        #1. 前序遍历数组的每个节点都可以将中序遍历数组的节点分为以该节点的左右两个子树
        #2. 取出前序数组的第一个节点构建节点，然后在中序数组里找到该节点的位置，切分成左右两个子数组a,b
        #3. 继续取出前序数组的节点，并在a中按照12构建子树，直到a的元素全部构建完成，此时前序数组取出的节点才会在b数组里面，同样在b构建子树，直到b的元素都构建完。
        def bulid(left, right):
            if left > right:
                return None
            print(self.pre_index)
            root_val = preorder[self.pre_index]
            root = TreeNode(root_val)
            index = inorder.index(root_val)
            self.pre_index += 1
            root.left = bulid(left, index - 1)
            root.right = bulid(index + 1, right)
            return root
            
            
        self.pre_index = 0
        return bulid(0, len(inorder) - 1)
        
            
        
        