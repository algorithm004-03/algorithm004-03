# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        list1 = []
        if root is None:
            return []
        list1.append(root.val)
        list1 += self.preorderTraversal(root.left)
        list1 += self.preorderTraversal(root.right)
        return list1
