import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树，返回它的 前序 遍历。
 */
public class LeetCode_144_648 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List < Integer > list = new ArrayList< >();
        helper(list, root);
        return list;
    }
    private void helper(List<Integer> list,TreeNode root){
        if(root!=null){
            list.add(root.val);
            helper(list,root.left);
            helper(list,root.right);
        }
    }


    public static class TreeNode {
        int val;
        LeetCode_144_648.TreeNode left;
        LeetCode_144_648.TreeNode right;
        TreeNode(int x){
            this.val = x;
        }

    }
    public static void main(String[] args) {
        LeetCode_144_648 leetCode_94_648 = new LeetCode_144_648();
        LeetCode_144_648.TreeNode treeNode = new LeetCode_144_648.TreeNode(1);
        treeNode.right=new LeetCode_144_648.TreeNode(2);
        treeNode.left=new LeetCode_144_648.TreeNode(3);
        List < Integer > list  = leetCode_94_648.preorderTraversal(treeNode);
        System.out.println(list);
    }
}
