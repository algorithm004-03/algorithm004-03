import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的中序 遍历
 *
 */
public class LeetCode_94_648 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List < Integer > list = new ArrayList< >();
        inorderTraver(list, root);
        return list;
    }
    private void inorderTraver(List<Integer> list,TreeNode root){
        if(root!=null){
            if(root.left!=null){
                inorderTraver(list,root.left);
            }
            list.add(root.val);
            inorderTraver(list,root.right);
        }
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            this.val = x;
        }

    }

    public static void main(String[] args) {
        LeetCode_94_648 leetCode_94_648 = new LeetCode_94_648();
        TreeNode treeNode = new TreeNode(1);
        treeNode.right=new TreeNode(2);
        treeNode.left=new TreeNode(3);
        List < Integer > list  = leetCode_94_648.inorderTraversal(treeNode);
        System.out.println(list);
    }
}


