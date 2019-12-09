/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * 分治，通过前序列表第一个元素，找到其在中序数组中位置K，
 * 将中序分解成以K为分界点的左，右两个数组，
 * 同步将 前序列表，从第二个元素至最后一个元素 分解为前后两个数组，分别对应中序左右两个数组长度
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length ==0 || inorder.length ==0 ){
            return null;
        }
        return findSon(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }

    public TreeNode findSon(
            int[] preorder,
            int[] inorder,
            int preorderS,
            int preorderE,
            int inorderS,
            int inorderE
    ){
        //退出条件
        TreeNode currentNode = null;
        if(preorderS == preorderE){
            currentNode = new TreeNode(preorder[preorderS]);
            //加速收敛，可多打败18%
        }else if(inorderS == inorderE){
            currentNode = new TreeNode(inorder[inorderE]);
        }else{
            currentNode = new TreeNode(preorder[preorderS]);
            //找到inorder中该节点下标
            int k = 0;
            for(int i=0; (i+inorderS) <=inorderE;i++){
                if(inorder[i+inorderS] == preorder[preorderS]){
                    k = i;
                    break;
                }
            }
            if(k==0){
                currentNode.left = null;
            } else {
                currentNode.left = findSon(preorder,inorder,preorderS+1,preorderS+k,inorderS,inorderS+k-1);
            }




            if(inorderS+k == inorderE){
                currentNode.right = null;
            }else{
                currentNode.right = findSon(preorder,inorder,preorderS+k+1,preorderS,inorderS+k+1,inorderE);
            }



        }
        return currentNode;

    }

}
// @lc code=end



//方法二,在上面的基础上,因为每次需要查某元素在中序中的位置取K值,推想是否用可以缓存元素在中序中的位置,利用位置差代置每次循环计算K值。
