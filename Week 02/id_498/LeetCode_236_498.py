# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def __init__(self):
        self.public_ancestor = None

    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        """
        二叉树的最近公共祖先，这个祖先有可能在左也可能在右，也可能在中间。
        所以遍历所有的节点，找到与目标相符的就标记为True。
        如果某个节点有两个True，就证明他是公共祖先。
        """

        def backtrack(b_root):
            # 判断是否根节点
            if not b_root:
                return False
            # 分发到左右节点
            left = backtrack(b_root.left)
            right = backtrack(b_root.right)
            # 如果当前根节点和 p、q 相等就返回 True
            current = b_root == p or b_root == q
            # 如果有两个是 True 就是公共祖先
            # 这样就会覆盖了原有公共父节点
            ### self.public_ancestor = b_root if current + left + right > 1 else None ###
            if current + left + right > 1:
                self.public_ancestor = b_root
            # 给递归个返回值
            # 如果证明左右根节点有 True，证明当前节点在pq的连接点上
            return current or left or right

        backtrack(root)
        return self.public_ancestor
