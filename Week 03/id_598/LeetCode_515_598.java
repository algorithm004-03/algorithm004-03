import java.util.*;

/**
 * @author northleaf
 * @create 2019年10月31日
 */
public class LeetCode_515_598 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 递归查找每一层最大的值
     *  DFS算法
     * @param root
     * @return
     */
    public List<Integer> largestValues1(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        helper(0,root,map);
        List<Integer> list =  new ArrayList<Integer>(map.values());
        return list;
    }

    /**
     * 递归查找
     * @param depth
     */
    private void helper(int depth, TreeNode node, Map<Integer,Integer> map){
        //终止条件
        if (node == null) {
            return;
        }
        //处理当前层
        if(map.get(depth) == null){
            map.put(depth,node.val);
        }else{
            map.put(depth,Math.max(node.val,map.get(depth)));
        }
        //下一层
        helper(depth+1,node.left,map);
        helper(depth+1,node.right,map);
        //数据清理
    }

    /**
     * 非递归方式，查找每一层最大的值
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        //借助一个队列实现
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //从第0层开始
        int level = 0 ;
        TreeNode tmpNode = null;
        //遍历queue，每次遍历就是一层的数据
        while (!queue.isEmpty()){
            //获取当前层的元素数量
            int level_num_length = queue.size();
            int tmp  = Integer.MIN_VALUE;
            //遍历当前层的数据
            for(int i = 0;i<level_num_length;i++){
                tmpNode = queue.remove();
                tmp = Math.max(tmp,tmpNode.val);
                if(tmpNode.left!=null){
                    queue.add(tmpNode.left);
                }
                if(tmpNode.right!=null){
                    queue.add(tmpNode.right);
                }
            }
            list.add(tmp);



            //处理下一层
            level ++;
        }

        return list;
    }

}
