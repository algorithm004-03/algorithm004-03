package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 14. 最长公共前缀	https://leetcode-cn.com/problems/longest-common-prefix/
 * @Date 2019/12/04
 */
public class LeetCode_14_693 {

    /**
     * 随机选取一个字符串，然后一直截取前部分直到indexOf 为0，循环所有字符串，最后的截取出的字符就是结果
     */
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            int len = strs.length;
            if (len == 0) return "";
            String sub = strs[0];
            for (String str : strs) {
                while (str.indexOf(sub) != 0) {
                    sub = sub.substring(0,sub.length() - 1);
                    if (sub.length() == 0) {
                        return "";
                    }
                }
            }
            return sub;
        }
    }

    /**
     * 字符树解法，可以继续优化，因为后面发现total不等于0 那么就没必要继续新建了。因为代表这里已经不同了，剪枝
     */
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            int len = strs.length;
            String res = "";
            if (len == 0) return res;
            Trie trie = new Trie();
            trie.build(strs);
            Node node = trie.root;
            for (char ch : strs[0].toCharArray()) {
                node = node.children[ch - 'a'];
                if (node.total != strs.length) return res;
                res += ch;
            }
            return res;

        }

        class Trie {
            Node root = new Node();

            public void build(String[] strs) {
                for (String str : strs) {
                    Node temp = root;
                    temp.total++;
                    for (char ch : str.toCharArray()) {
                        if (temp.children[ch - 'a'] == null) {
                            temp.children[ch - 'a'] = new Node();
                        }
                        temp = temp.children[ch - 'a'];
                        temp.total++;
                    }

                }
            }
        }

        class Node {
            int total = 0;
            Node[] children;

            public Node() {
                children = new Node[26];
            }
        }
    }

}
