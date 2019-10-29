from typing import List


class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution1:
    """
    This is a recursive solution
    """

    def postorder(self, root: Node) -> List[int]:
        res = []
        self._postorder(root, res)
        return res

    def _postorder(self, root: Node, res: List[int]) -> List[int]:
        if root:
            # first visit all the children
            for node in root.children:
                self._postorder(node, res)
            # finally visit root
            res.append(root.val)


class Solution2:
    """
    This is an iterative solution
    """

    def postorder(self, root: Node) -> List[int]:
        # edge case root is empty
        if not root: return []
        stack, res = [root], []
        while stack:
            node = stack.pop()
            if node.children:
                for child in node.children:
                    stack.append(child)
            res.insert(0, node.val)
        return res
