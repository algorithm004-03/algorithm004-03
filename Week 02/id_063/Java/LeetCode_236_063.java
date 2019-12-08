/*
思路

dfs分别查找从根节点到两个节点的路径，然后查找两条路径中离根最远的且数值相等的节点
 */


import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }


class Solution {

    boolean dfs(TreeNode curNode, int target, List<Integer> path) {
        if (curNode == null) {
            return false;
        }

        path.add(curNode.val);
        if (curNode.val == target) {
            return true;
        }

        if (dfs(curNode.left, target, path)) {
            return true;
        }

        if (dfs(curNode.right, target, path)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> path1 = new ArrayList<Integer>();
        List<Integer> path2 = new ArrayList<Integer>();

        dfs(root, p.val, path1);
        dfs(root, q.val, path2);

        List<Integer> tmp = null;
        if (path1.size() > path2.size()) {
            tmp = path1;
            path1 = path2;
            path2 = tmp;
        }

        Set<Integer> set = new HashSet<>(path2);
        TreeNode retNode = new TreeNode(0);
        for (int i = path1.size()-1; i >= 0; i--) {
            if (set.contains(path1.get(i))) {
                retNode.val = path1.get(i);
                break;
            }
        }

        return retNode;
    }
}