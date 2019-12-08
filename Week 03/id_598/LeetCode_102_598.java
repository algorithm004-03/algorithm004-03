import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author northleaf
 * @create 2019年10月31日
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
     * 层次遍历：递归方式实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            levelOrder(0, root, ans);
        }

        return ans;
    }

    /**
     * 层次遍历递归实现类
     *
     * @param dept
     * @param node
     * @param ans
     */
    private void levelOrder(int dept, TreeNode node, List<List<Integer>> ans) {
        //终止条件
        if (node == null) {
            return;
        }
        //处理当前层的数据
        List<Integer> tmp = null;
        //由于dept是由0开始的，而list集合内如果有元素，就一定是大于0的
        //比如dept为0，那就判断，如果下一层的数量大于list集合的数据，说明一定没有当前层
        if (dept + 1 > ans.size()) {
            tmp = new ArrayList<>();
            ans.add(tmp);
        }
        tmp = ans.get(dept);
        tmp.add(node.val);
        //下一层
        levelOrder(dept + 1, node.left, ans);
        levelOrder(dept + 1, node.right, ans);

        //清理数据

    }


    /**
     * 层序遍历：迭代法
     * 借助于队列实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        //起始时，元素只有根节点
        queue.add(root);
        //从第0层开始
        int level = 0;
        //判断队列是否为空，不为空则持续循环
        //这个while每循环一次就是一层的数据
        while (!queue.isEmpty()){
            ans.add(new ArrayList<>());
            //根据当前队列的长度获取当前层的数据
            //同时将节点的子节点添加到队列中
            int num_length = queue.size();
            for(int i = 0;i<num_length;i++){
                TreeNode node = queue.remove();
                ans.get(level).add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            //进入下一层
            level++;

        }

        return ans;
    }
}
