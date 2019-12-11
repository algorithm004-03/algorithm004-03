#
# @lc app=leetcode id=297 lang=python3
#
# [297] Serialize and Deserialize Binary Tree
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        return self._serialize(root, '')
        
    def _serialize(self, root, s):
        if root is None:
            s += 'None,'
            return s
        s += str(root.val) + ','
        s = self._serialize(root.left, s)
        s = self._serialize(root.right, s)
        return s
        
    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        data_list = data.split(',')
        return self._deserialize(data_list)
    
    def _deserialize(self, l):
        if l[0] == 'None':
            l.pop(0)
            return None     
        root = TreeNode(l[0])
        l.pop(0)
        root.left = self._deserialize(l)
        root.right = self._deserialize(l)
        return root
'''
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        def _serialize(root, s):
            if not root:
                s += 'None,'
                return s 
            s += str(root.val) + ','
            s = _serialize(root.left, s)
            s = _serialize(root.right, s)
            return s
        return _serialize(root, '')

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        def _deserialize(l):
            if l[0] == 'None':
                l.pop(0)
                return None
            root = TreeNode(l[0])
            l.pop(0)
            root.left = _deserialize(l)
            root.right = _deserialize(l)
            return root
        data_list = data.split(',')
        return _deserialize(data_list)
'''
# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))
# @lc code=end

