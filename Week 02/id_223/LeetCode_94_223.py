class Solution:   
    def __init__(self):      
        self.traverse_path = []
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if root:
            self.inorderTraversal(root.left);
            self.traverse_path.append(root.val) 
            self.inorderTraversal(root.right)
        return self.traverse_path