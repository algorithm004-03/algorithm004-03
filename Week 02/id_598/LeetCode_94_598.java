import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode第94题
 *
 * @author northleaf
 * @create 2019年10月22日
 */
public class LeetCode_94_598 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 中序遍历：左根右
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorderTraversal(list,root) ;
        return list;
    }

    /**
     * 中序遍历以Node为根的二叉树
     * @param list
     * @param node
     */
    private void inorderTraversal(List<Integer> list, TreeNode node) {
        if(node!=null){
            inorderTraversal(list,node.left);
            list.add(node.val);
            inorderTraversal(list,node.right);

        }
    }


    /**
     * 基于栈的中序遍历：左根右
     *  1. 定义List<Integer>
     *  2. 定义栈
     *  3. 定义root节点为curr节点
     *  4. 将curr节点及其所有的左子树依次入栈
     *  5. 栈顶元素出栈并访问，同时获取右子树
     *  6. 对右子树重复执行4，5两步骤
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        //定义结果集
        List<Integer> list = new ArrayList<Integer>();
        //定义栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //将root节点设置为curr
        TreeNode curr = root;
        //循环遍历 --栈不为空说明栈中还有元素没有遍历
        while(curr!=null || !stack.isEmpty()){
            //将所有的左子树入栈
            while (curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            //当前栈顶一定是最左下角的元素
            curr = stack.pop();
            list.add(curr.val);
            //将节节的右子树分配给curr
            curr = curr.right;
        }

        return list;
    }

}
