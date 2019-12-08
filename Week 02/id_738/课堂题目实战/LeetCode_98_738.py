# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isValidBST(self, root):
        """
        验证二叉搜索树：https://leetcode-cn.com/problems/validate-binary-search-tree/

        :type root: TreeNode
        :rtype: bool
        """
        
        #中序遍历二叉树，每次遍历一个节点，判断该节点的数值是否比之前遍历过的节点的最大值还大即可
        #中序遍历用递归遍历
        # if not root:
        #     return True
        # self.max_val = None
        # return self.valid(root)
    
        #递归：判断当前节点是否落在上下界，如果是，则继续递归判断左右子树
        def valid(cur, lower = float('-inf'), upper = float('inf')):
            if not cur:
                return True
            val = cur.val
            if lower < val < upper:
                if not valid(cur.left, lower, val):
                    return False
                if not valid(cur.right, val, upper):
                    return False
            else:
                return False
            return True
        return valid(root)
            
            
            
        
    #中序遍历二叉树，每次遍历一个节点，判断该节点的数值是否比之前遍历过的节点的最大值还大即可    
    # def valid(self, cur):
    #     if cur:
    #         isValid = self.valid(cur.left)
    #         if isValid:
    #             if self.max_val == None or cur.val > self.max_val:
    #                 self.max_val = cur.val
    #             else:
    #                 isValid = False
    #             if isValid:
    #                 isValid = self.valid(cur.right)
    #             print(isValid)
    #         return isValid
    #     else:
    #         return True