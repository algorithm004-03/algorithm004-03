/*
思路
简单前序遍历，没什么特殊算法
*/

public class Solution {
    private List<Integer> dfs(List<Integer> result, TreeNode curNode) {
        if (curNode == null) {
            return result;
        }

        result.add(curNode.val);
        return dfs(dfs(result, curNode.left), curNode.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        return dfs(new LinkedList<>(), root);
    }
}