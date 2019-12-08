import jdk.nashorn.internal.runtime.options.Option;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_102_548 {


    List <List <Integer>> levels = new ArrayList <List <Integer>> ();

    /**
     *
     * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
     *
     * 例如:
     * 给定二叉树: [3,9,20,null,null,15,7],
     *
     *     3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * 返回其层次遍历结果：
     *
     * [
     *   [3],
     *   [9,20],
     *   [15,7]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param args
     */


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode ( 3 );
        TreeNode treeNode2 = new TreeNode ( 9 );
        TreeNode treeNode3 = new TreeNode ( 20 );
        TreeNode treeNode6 = new TreeNode ( 15 );
        TreeNode treeNode7 = new TreeNode ( 7 );

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;


        LeetCode_102_548 levelOrder = new LeetCode_102_548 ();

        List <List <Integer>> levels = levelOrder.levelOrder ( treeNode1 );

        System.out.println ( "levels: " + levels.toString () );


    }

    /**
     * 1。输出列表称为 levels。 结构是 ArrayList<List<Integer>>();
     * <p>
     * 2。 比较访问节点所在的层次 level 和当前最高层次 len(levels) 的大小
     * 当访问下一层的时候，level>len(levels)的时候。向level添加一个新的列表
     * <p>
     * 3。递归遍历左右子树 helper（node.left/node.rigth, level+1）(访问下一层)
     */


    public List <List <Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return levels;
        }
        helper ( root, 1 );
        return levels;
    }


    public void helper(TreeNode node, int level) {

        //1.比较访问节点所在的层次 level 和当前最高层次 len(levels) 的大小, 当访问下一层的时候，level>len(levels)的时候。向level添加一个新的列表
        if (levels.size () < level) {
            levels.add ( new ArrayList <Integer> () );
        }

        //2. 把当前节点的值，保留到本层
        levels.get ( level - 1 ).add ( node.val );

        //遍历左右子树
        if (node.left != null) {
            helper ( node.left, level + 1 );
        }

        if (node.right != null) {
            helper ( node.right, level + 1 );
        }


    }


}
