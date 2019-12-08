//给定一个 N 叉树，返回其节点值的后序遍历。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

package com.modds.alltest.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode_590_443_NAryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode_590_443_NAryTreePostorderTraversal().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
    class Solution {
        private List<Integer> list = new LinkedList<>();

        public List<Integer> postorder(Node root) {
            if (root == null) return list;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                list.add(0, node.val);
                for (Node child : node.children) {
                    stack.push(child);
                }
            }

            return list;
        }

        public List<Integer> postorder1(Node root) {
            if (root == null) return list;
            for (Node child : root.children) {
                postorder(child);
            }
            list.add(root.val);

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}