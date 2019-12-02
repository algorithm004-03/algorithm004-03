package Week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Date 2019/10/28.
 * @see <a href="102">https://leetcode-cn.com/problems/binary-tree-level-order-traversal/#/description</a>
 * 二叉树的层次遍历
 */
public class LeetCode_102_558 {

    /**
     * 思路：
     * 方法一：广度优先
     * 1、先遍历本层，把下一级元素存储起来
     * 2、递归遍历下一级元素
     * 方法二：深度优先
     * 递归遍历时传入层级
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        if (root != null) {
            nodes.add(root);
        }
        traversal(lists, nodes);
        return lists;
    }


    private static void traversal(List<List<Integer>> lists, ArrayList<TreeNode> nodes) {
        if (nodes == null || nodes.size() <= 0) {
            return;
        }
        List<Integer> list = new ArrayList<Integer>();
        ArrayList<TreeNode> currentLevelNodes = new ArrayList<TreeNode>();
        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            list.add(node.val);
            if (node.left != null) {
                currentLevelNodes.add(node.left);
            }
            if (node.right != null) {
                currentLevelNodes.add(node.right);
            }
        }
        lists.add(list);
        traversal(lists, currentLevelNodes);
    }


    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (root == null) {
            return lists;
        }
        Queue<List<TreeNode>> queue = new LinkedList<List<TreeNode>>();
        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(root);
        queue.add(nodes);
        while (!queue.isEmpty()) {
            List<TreeNode> currentLevelNodes = queue.remove();
            ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
            List<Integer> list = new ArrayList<Integer>();
            for (TreeNode node : currentLevelNodes) {
                list.add(node.val);
                if (node.left != null) {
                    nodeList.add(node.left);
                }
                if (node.right != null) {
                    nodeList.add(node.right);
                }
            }
            if (list.size() > 0) {
                lists.add(list);
            }
            if (nodeList.size() > 0) {
                queue.add(nodeList);
            }
        }
        return lists;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode20 = new TreeNode(20);
        TreeNode treeNode15 = new TreeNode(15);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode3.left = treeNode9;
        treeNode3.right = treeNode20;

        treeNode20.left = treeNode15;
        treeNode20.right = treeNode7;

        System.out.println(levelOrder2(treeNode3));
    }
}
