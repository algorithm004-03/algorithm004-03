# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        """
        二叉树的最近公共祖先：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
        
        :type root: TreeNode
        :type p: TreeNode
        :type q: TreeNode
        :rtype: TreeNode
        """
        #1. 如果当前节点为p,q中的一个，那么只要该节点的左右子树中包含另外一个节点，则该节点即是公共祖先
        #2. 如果当前节点不为p,q中的一个，那么该节点的左子树 和 右子树 中分别包含q和p，则该节点是公共祖先
        #3. 否则，当前该节点不是公共祖先
        #4. 所以转化为：在递归的情况下（递归是从底部往根部回溯的机制），判断当前节点，左子树，右子树中的其中2个是否包含p和q，如果是，则当前节点为公共祖先
        self.result = None
        def find(cur, p, q):
            if not cur or self.result:
                #如果self.result已经被赋值，表示已经找到最近公共祖先了，那么cur节点上层的节点，必然是本身节点不为pq,并且左右子树只有一个子树包含pq的情况，所以会一直跳过去。。
                return False
            cur_is = cur.val == p.val or cur.val == q.val
            left_is = find(cur.left, p, q)
            right_is = find(cur.right, p, q)
            if cur_is + left_is + right_is >= 2:
                #这里如此处理不需要担心后面回溯会覆盖self.result是因为：
                self.result = cur
            return cur_is or left_is or right_is
            
        find(root, p, q)
        return self.result
        
        