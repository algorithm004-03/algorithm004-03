class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children


class Solution:
    def postorder(self, root: 'Node') -> List[int]:

        rt = list([])
        if not root:
            return rt
        for cr in root.children:
            rt.extend(self.postorder(cr))
        rt.append(root.val)
        return rt
