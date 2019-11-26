from typing import List


class TreeNode:
    def __init__(self, x: int):
        self.val = x
        self.left, self.right = None, None


class Solution1:
    """
    This solution is recursive
    """

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if root:
            self._inorder_tra(root, res)
        return res

    def _inorder_tra(self, root: TreeNode, res: List[int]) -> List[int]:
        if root:
            if root.left:
                self._inorder_tra(root.left, res)
            res.append(root.val)
            if root.right:
                self._inorder_tra(root.right, res)
        return res


class Solution2:
    """
    This solution is iterative
    """

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res, stack = [], []
        while True:
            while root:
                # this reflects in-order, as FILO
                stack.append(root)
                root = root.left
            if not stack:
                return res
            node = stack.pop()
            res.append(node.val)
            root = node.right
