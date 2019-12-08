package week2;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: leetcode
 * @description: Construct Binary Tree from Preorder and Inorder Traversal
 * @author: 王瑞全
 * @create: 2019-10-2519:13
 **/


public class leetcode105_2_468 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length,preorder,inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preOrder, int[] inOrder) {
      if(preStart>preOrder.length-1||inStart>inEnd){
          return null;
      }
      TreeNode treeNode=new TreeNode(preOrder[preStart]);
      int index=0;
      for(int i=inStart;i<=inEnd;i++){
        if(treeNode.val==inOrder[i]){
          index=i;
        }
      }
      treeNode.left=helper(preStart+1,inStart,index-1,preOrder,inOrder);
      treeNode.right=helper(preStart+index-inStart+1,index+1,inEnd,preOrder,inOrder);
      return treeNode;
    }
}
