/*
思路
简单中序遍历，没什么特殊算法
*/

public class Solution {
    private List<Integer> dfs(List<Integer> result, TreeNode curNode) {
        if (curNode == null) {
            return result;
        }

        dfs(result, curNode.left).add(curNode.val);
        return dfs(result, curNode.right);
    }


    public List<Integer> inorderTraversal(TreeNode root) {
        return dfs(new LinkedList<>(), root);
    }
}