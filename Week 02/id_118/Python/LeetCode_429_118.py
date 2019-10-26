class Node:
    def __init__(self, val, children):
        self.val, self.children = val, children


class Solution:
    def level_order(self, root):
        if not root: return []
        queue, res = [root], []
        while queue:
            res.append([node.val for node in queue])
            queue = [child for node in queue for child in node.children]
        return res
