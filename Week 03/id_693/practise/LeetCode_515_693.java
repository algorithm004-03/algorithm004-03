package id_693.practise;

import com.sun.jmx.remote.internal.ArrayQueue;
import id_693.TreeNode;

import java.util.*;

/**
 * @Author 李雷（KyLin）
 * @Desc 515. 在每个树行中找最大值	https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 * @Date 2019/10/30
 */
public class LeetCode_515_693 {
    //迭代法bfs
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            int currentMax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = deque.poll();
                currentMax = Math.max(currentMax,temp.val);
                if (temp.left != null) {
                    deque.offer(temp.left);
                }
                if (temp.right != null) {
                    deque.offer(temp.right);
                }

            }
            result.add(currentMax);
        }
        return result;
    }

    //递归法bfs
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        recurrsion(result,root,0);
        return result;
    }

    private void recurrsion(List<Integer> result,TreeNode root,int level) {
        if (root != null) {
            if (level == result.size()) {
                result.add(root.val);
            } else if (root.val > result.get(level)) {
                result.set(level,Math.max(root.val,result.get(level)));
            }
            recurrsion(result,root.left,level + 1);
            recurrsion(result,root.right,level + 1);
        }
    }
}
