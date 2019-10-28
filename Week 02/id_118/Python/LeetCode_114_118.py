from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution1:
    """
    This is the recursive solution
    """

    def pre_order_traverse(self, root: TreeNode) -> List[int]:
        res = []
        self._pre_order(root, res)
        return res

    def _pre_order(self, root, res):
        if root:
            res.append(root.val)
            self._pre_order(root.left, res)
            self._pre_order(root.right, res)


class Solution2:
    """
    This is the iterative solution
    """

    def pre_order_traverse(self, root: TreeNode) -> List[int]:
        stack, res = [root], []
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return res
