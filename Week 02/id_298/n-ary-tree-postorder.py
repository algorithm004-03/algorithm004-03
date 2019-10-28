"""
# Definition for a Node.
class Node:
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
      result = []
      if root is None:
        return result
      def _postorder(root):
        if root is None:
          return
        for child in root.children:
          _postorder(child)
          result.append(child.val)
      _postorder(root)
      result.append(root.val)
      return result

"""
{"$id":"1","children":[{"$id":"2","children":[{"$id":"5","children":[],"val":5},{"$id":"6","children":[],"val":6}],"val":3},{"$id":"3","children":[],"val":2},{"$id":"4","children":[],"val":4}],"val":1}
递归访问完了children后才访问到val, val后序
所以是
children: _postorder(root)
val     : root.val

children是一个列表，里面包含{children, val}

改进方法：列表递归的写法？
"""
