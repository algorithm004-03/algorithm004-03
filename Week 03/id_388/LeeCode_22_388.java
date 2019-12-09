package com.company.leetcode.editor.cn;
//给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
//
// 例如，给出 n = 3，生成结果为：
//
// [
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
//
// Related Topics 字符串 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution_22 {

    class Node {
        int leftCount;
        int rightCount;
        String val;

        public Node(int leftCount, int rightCount, String val) {
            this.leftCount = leftCount;
            this.rightCount = rightCount;
            this.val = val;
        }

        public Node(Node node) {
            this.leftCount = node.leftCount;
            this.rightCount = node.rightCount;
            this.val = node.val;
        }
    }

    //广度优先搜索
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n <= 0) {
            return res;
        }

        Node node = new Node(1,0,"(");
        LinkedList<Node> queue = new LinkedList<>();
        queue.addFirst(node);
        while (!queue.isEmpty()) {

            int size = queue.size();
            while (size > 0) {
                Node curr = queue.pollFirst();
                size--;
                if (curr.leftCount == curr.rightCount && curr.leftCount == n) {
                    res.add(curr.val);
                    continue;
                }

                if (curr.leftCount < n) {
                    Node newNode = new Node(curr);
                    newNode.val = curr.val + "(";
                    newNode.leftCount++;
                    queue.addFirst(newNode);
                }

                if (curr.rightCount < curr.leftCount) {
                    Node newNode = new Node(curr);
                    newNode.val =  curr.val + ")";
                    newNode.rightCount++;
                    queue.addFirst(newNode);
                }
            }

        }
        return res;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        List res = s.generateParenthesis(3);
//        System.out.println(res.toString());
//    }

    private List res;
    public List<String> generateParenthesis2(int n) {
        res = new ArrayList();
        helper(0,0,n,"");

        return res;
    }

    private void helper(int left,int right,int n,String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            helper(left + 1,right,n,s + "(");
        }
        if (right < left) {
            helper(left,right + 1,n,s + ")");
        }

    }

}
//leetcode submit region end(Prohibit modification and deletion)
