package com.test.leetcode.week02;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class SolutionBuildTree105 {


    @Test
    public void test1() {
        TreeNode node = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNode node2 = buildTree2(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println(node);
        System.out.println(node2);
    }



    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder,  inorder, (long)Integer.MAX_VALUE + 1);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        //到达末尾返回 null
        if(pre == preorder.length){
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //左子树的停止点是当前的根节点
        root.left = buildTreeHelper(preorder,  inorder, root_val);
        //右子树的停止点是当前树的停止点
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }



    /**
     * 重复子问题：获取中序遍历的第一个节点左右跟节点，然后使用这个跟节点切分中序遍历的数组
     * @param preorder
     * @param inorder
     * @return
     */
    int preRootIndex = 0;
    int[] preorder ;
    int[] inorder;
    Map<Integer, Integer> inOrderMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        for (int i = 0; i < inorder.length; i ++) {
            inOrderMap.put(inorder[i], i);
        }
        return helper(0, inorder.length);
    }

    private TreeNode helper(int left, int right) {
        // 递归终止条件
        if (left == right) {
            return null;
        }
        // 处理当前层逻辑
        int rootVal = preorder[preRootIndex ++];
        TreeNode root = new TreeNode(rootVal);
        Integer mid = inOrderMap.get(rootVal);
        // 下探到下一层
        root.left = helper(left, mid);
        root.right = helper(mid + 1, right);
        // 清理当前层
        return root;

    }

}
