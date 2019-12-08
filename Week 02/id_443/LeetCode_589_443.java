//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

package com.modds.alltest.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_589_443_NAryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution solution = new LeetCode_589_443_NAryTreePreorderTraversal().new Solution();
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
        private List<Integer> list = new ArrayList<>();

        public List<Integer> preorder(Node root) {
            if(root == null) return list;
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while (!stack.empty()) {
                Node node = stack.pop();
                list.add(node.val);
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.push(node.children.get(i));
                }
            }
            return list;
        }

        public List<Integer> preorder1(Node root) {
            if (root == null) return list;

            list.add(root.val);
            for (Node child : root.children) {
                preorder(child);
            }

            return list;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}