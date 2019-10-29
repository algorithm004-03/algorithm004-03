class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root: return []
        res = []
        queue = [(0, root)]
        while queue:
            level, node = queue.pop(0)
            if len(res) == level:
                res.append([node.val])
            else:
                res[level].append(node.val)
            if node.children:
                for i in node.children:
                    queue.append((level + 1, i))
        return res