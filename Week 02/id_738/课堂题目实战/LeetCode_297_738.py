# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


"""
二叉树的序列化与反序列化：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
"""
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        #深度遍历
        def ser(cur, s):
            if not cur:
                return s + "None,"
            else:
                string = ser(cur.left,  s + str(cur.val) + ',')
                string = ser(cur.right, string)
                return string
        s = ser(root, '')
        return s
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        #反序列化，也是用递归
        def deser(data):
            d = data.pop(0)
            if d == 'None':
                return None
            cur = TreeNode(d)
            cur.left = deser(data)
            cur.right = deser(data)
            return cur
        
        
        data_list = data.split(',')
        return deser(data_list)
        
        
        
        

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize(codec.serialize(root))