# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
class Solution:
    p  = 0
    preorder: List[int]
    inorder: List[int]
    def dfs(self,lb,rb):
        if lb>rb:
            return None
        node = TreeNode(self.preorder[self.p])
        self.p+=1
        mid = self.inorder.index(node.val)
        node.left = self.dfs(lb,mid-1)
        node.right = self.dfs(mid+1,rb)
        return node
    def buildTree(self, preorder: List[int], inorder: List[int]) -> TreeNode:
        self.preorder = preorder
        self.inorder = inorder
        p = 0
        return self.dfs(0,len(inorder)-1)
