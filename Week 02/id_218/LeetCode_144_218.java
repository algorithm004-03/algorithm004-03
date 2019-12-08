package leetcode.week2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author eason.feng at 2019/10/23/0023 20:33
 **/
public class LeetCode_144_218 {

    public List<Integer> preorderTraversalWithoutLoop(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        return list;
    }

    public List<Integer> preorderTraversalWithLoop(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        loops(root, list);
        return list;
    }

    private void loops(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            loops(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            loops(root.right, list);
        }
    }

    public static void main(String[] args) {
        LeetCode_144_218 l = new LeetCode_144_218();
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode (int x) {
        this.val = x;
    }
}
