class Solution {
//二叉树的中序遍历，就是左根右遍历。
    public List<Integer> inorderTraveesal(TreeNode root) {
        List<Integer> list = new ArrayList();
        sortt(list, root);
        return list;
    }
    public void sortt(List list, TreeNode root) {
        if (root != null) {
            if(root.left != null) 
                sortt(list, root.left);
            list.add(root.val);
            if(root.right != null) 
                sortt(list, root.right);
        }
    }
//前序遍历，顾名思义就是根左右。
    public List<Integer> inorderTraveesal(TreeNode root) {
        List<Integer> list = new ArrayList();
        sortt(list, root);
        return list;
    }
    public void sortt(List list, TreeNode root) {
        if (root != null) {
            list.add(root.val);
            if(root.left != null) 
                sortt(list, root.left);
            if(root.right != null) 
                sortt(list, root.right);
        }
    }

}