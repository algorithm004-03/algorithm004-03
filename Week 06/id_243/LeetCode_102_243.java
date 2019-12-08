import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author eazonshaw
 * @date 2019/11/22  10:13
 */
public class LeetCode_102_243 {

    //BFS Queue
    public List<List<Integer>> levelOrder(TreeNode root) {
        //结果集
        List<List<Integer>> rs = new ArrayList<>();
        //边界情况处理
        if(root == null){
            return rs;
        }
        //维护一个队列
        Deque<TreeNode> queue = new LinkedList<>();
        //入队
        queue.add(root);
        //层数
        int level = 0;
        while (!queue.isEmpty()){
            //添加当前层集合
            rs.add(level,new ArrayList<>());
            //遍历当前层
            int len = queue.size();
            for(int i = 0;i < len;i++){
                //出队
                TreeNode currNode = queue.removeFirst();
                //执行逻辑
                rs.get(level).add(currNode.val);
                //子节点入队
                if(currNode.left!=null){
                    queue.add(currNode.left);
                }
                if(currNode.right!=null){
                    queue.add(currNode.right);
                }
            }
            level++;
        }
        return rs;
    }

    //递归
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> rs = new ArrayList<>();
        fc(root,0, rs);
        return rs;
    }
    //递归函数
    private void fc(TreeNode node,int level,List<List<Integer>> rs){
        //终止条件
        if(node == null){
            return;
        }
        //执行当前层逻辑
        if(rs.size() == level){
            rs.add(level,new ArrayList<>());
        }
        rs.get(level).add(node.val);
        //下坠
        level++;
        fc(node.left,level,rs);
        fc(node.right,level,rs);
    }

}
