class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:

        rt = list([])
        if not root:
            return rt
        rt.append(root.val)
        for cr in root.children:
            rt.extend(self.postorder(cr))
        return rt
