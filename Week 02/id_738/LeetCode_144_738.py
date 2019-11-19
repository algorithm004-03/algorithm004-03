# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
        def __init__(self):
            self.result = []
    
        def preorderTraversal(self, root):
            """
            :type root: TreeNode
            :rtype: List[int]
            """
            #递归
            # if root:
            #     self.result.append(root.val)
            #     self.preorderTraversal(root.left)
            #     self.preorderTraversal(root.right)
            # return self.result

            #迭代1
            # stack = []
            # e = root
            # while stack or e:
            #     if e:
            #         stack.append(e)
            #         self.result.append(e.val)
            #         while e.left:
            #             e = e.left
            #             stack.append(e)
            #             self.result.append(e.val)
            #     e = stack.pop()
            #     e = e.right
            # return self.result
        
            #迭代2
            # stack = []
            # e = root
            # while stack or e:
            #     while e:
            #         self.result.append(e.val)
            #         stack.append(e)
            #         e = e.left
            #     e = stack.pop()
            #     e = e.right
            # return self.result
        
            #迭代3
            if not root: return []
            stack = [root]
            while stack:
                e = stack.pop()
                self.result.append(e.val)
                if e.right:
                    stack.append(e.right)
                if e.left:
                    stack.append(e.left)
            return self.result











