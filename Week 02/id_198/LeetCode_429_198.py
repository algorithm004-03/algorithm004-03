class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution(object):
    def levelOrder(self, root):
        rt = []
        if not root:
            return rt
        rt.append([root.val])
        nodes = root.children
        while nodes and len(nodes) > 0:
            rt.append([n.val for n in nodes])
            next = []
            for node in nodes:
                if node.children:
                    next.extend(node.children)
            nodes = next
        return rt