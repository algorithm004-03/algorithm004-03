import java.util.*;

/**
 * @author northleaf
 * @create 2019年11月19日
 */
public class LeetCode_102_598 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用BFS的方式进行遍历,借助于队列
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()){

            List<Integer> tmp = new ArrayList<Integer>();
            //遍历queue
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode tnode = queue.remove();
                tmp.add(tnode.val);
                //是否有子节点，有则添加
                if (tnode.left != null) {
                    queue.add(tnode.left);
                }
                if (tnode.right != null) {
                    queue.add(tnode.right);
                }
            }
            ans.add(tmp);
        }
        return ans;
    }


    /**
     * 使用DFS的方式，借助于栈
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
        helper(1,root,map);
        return new ArrayList(map.values());
    }

    /**
     * DFS遍历
     * @param level
     * @param node
     * @param map
     */
    private void helper(int level, TreeNode node, Map<Integer, List<Integer>> map) {
        if(node == null){
            return;
        }
        List<Integer> tmp = map.get(level);
        if (tmp == null) {
            tmp = new ArrayList<Integer>();
            map.put(level,tmp);
        }
        tmp.add(node.val);
        //下一层
        if(node.left!=null){
            helper(level+1,node.left,map);
        }
        if(node.right!=null){
            helper(level+1,node.right,map);
        }
    }
}
