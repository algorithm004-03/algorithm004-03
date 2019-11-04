package id_713;

import java.util.*;

/**
 * 429. N叉树的层序遍历
 */
public class LeetCode_429_NAryTreeLevelOrderTraversal {

    /*
    思路:
    1. 广度搜索, 使用队列, 进行层级扫描
        1. 先把第一个元素放进去
        2. 停止条件为队列为空
        3. 获取每一层数量
        4. 出这一层数量的元素, 同时添加这一层的子级别元素, 直到这一层出队完
        5. 这样就进入下一层了, 直到队列空 为止
     */


    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Deque<Node> deque = new ArrayDeque<>();
        deque.addFirst(root);

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();

            while (size > 0) {
                Node curr = deque.removeLast();
                list.add(curr.val);

                for (Node node : curr.children) {
                    if (node != null) {
                        deque.addFirst(node);
                    }
                }
                ans.add(list);
                size--;
            }
        }
        return ans;
    }

    /*
    递归处理方式:

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(root, 0, res);
        return res;
    }

    private void helper(Node root, int depth, List<List<Integer>> res) {
        if (root == null) return;
        //判断是否是新的一层
        if (depth + 1 > res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(depth).add(root.val);

        //处理子节点
        for (Node node : root.children) {
            if (node != null) {
                helper(node, depth + 1, res);
            }
        }
    }

     */

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

    /**
     * 242. 有效的字母异位词
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * <p>
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * <p>
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     * <p>
     * 说明:
     * 你可以假设字符串只包含小写字母。
     */
    public static class LeetCode_242_ValidAnagram {

        /*
        思路:
        1. 先搞懂"异位词的意思"
            一种把某个词或句子的字母的位置（顺序）加以改换所形成的新词，英文叫做anagram，词典把这个词翻译成“变位词”。
        2. 如果长度不一样, 则肯定不是异位词
        3. 方法1:
            1. hashMap统计单词s的字母频率, key字母, value词频
            2. 扫描单词t时, 减去统计的数字, 如果减到0, 则删除key
            3. 判断hashMap是否为空
        4. 方法2:
            1. 使用数组代替hashMap, 前提是只有字母, 没有除字母外的unicode
            2. 遍历单词长度时, 同时操作单词s/单词t, 对应字母位置的词频
            3. 最后查看数组中 是否有不为0的数据

         */

        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) return false; // 如果长度都不相等, 则不符合异位词的定义

            int[] arr = new int[26]; // 因为只有26个字母, 即不考虑Unicode的情况
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i)]++; // 先扫描单词s,记录词频, 增量为正值
                arr[t.charAt(i)]--; // 同时扫描单词s,记录词频, 增量为负值
                // 如果是异位词, 则所有slot(槽)中的值应正负抵消
                // 但一次循环单词s和单词t, 不一定操作同一个槽, 最终应该都是0, 这样可以在一个循环里搞定
            }

            for (int x : arr) { // 最终所有slot(槽)中的值应为0, 才是异位词
                if (x != 0) return false;
            }

            return true;
        }
    }
}
