from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution1:
    """
    This is a recursive solution
    """

    def preorder(self, root: Node) -> List[int]:
        # edge case
        if not root: return []
        res = []
        self._preorder(root, res)
        return res

    def _preorder(self, root, res):
        res.append(root.val)
        if root.children:
            for node in root.children:
                self._preorder(node, res)


class Solution2:
    """
    This is an iterative solution
    """

    def preorder(self, root):
        stack, res = [root], []
        while stack:
            node = stack.pop()
            if node:
                res.append(node.val)
                # reverse the children order
                for child in node.children[::-1]:
                    stack.append(child)
        return res
