package week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 您需要在二叉树的每一行中找到最大的值。
 * @author: 王瑞全
 * @create: 2019-11-0218:43
 **/


public class leetcode515_3_468 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<Integer> largestValues(TreeNode root) {
            Queue<TreeNode> queue=new LinkedList<>();
            List<Integer> res=new ArrayList<>();
            queue.add(root);
            int queueSize=root==null?0:1;
            while(queueSize>0){
                int largest=Integer.MIN_VALUE;
                for(int i=0;i<queueSize;i++){
                    TreeNode cur=queue.poll();
                    largest=Math.max(cur.val,largest);
                    if(cur.left!=null)queue.add(cur.left);
                    if(cur.right!=null)queue.add(cur.right);
                }
                res.add(largest);
                queueSize=queue.size();
            }
            return res;
    }
}
