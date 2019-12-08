package id_693;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author 李雷（KyLin）
 * @Desc 212. 单词搜索 II	https://leetcode-cn.com/problems/word-search-ii/
 * @Date 2019/11/21
 */
public class LeetCode_212_693 {
    //单词树解法
    class Solution {
        public List<String> findWords(char[][] board,String[] words) {
            Set<String> result = new HashSet<>();
            if (board.length == 0 || board[0].length == 0) return new ArrayList<>(result);
            TreeNode root = buildTree(words);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    dfs(result,board,root,i,j);
                }
            }
            return new ArrayList<>(result);
        }

        private void dfs(Set<String> result,char[][] board,TreeNode root,int i,int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '#') {
                return;
            }
            root = root.childrens[board[i][j] - 'a'];
            if (root == null) {
                return;
            }
            if (root.isWord) {
                result.add(root.val);
            }
            char temp = board[i][j];
            board[i][j] = '#';
            dfs(result,board,root,i + 1,j);
            dfs(result,board,root,i - 1,j);
            dfs(result,board,root,i,j - 1);
            dfs(result,board,root,i,j + 1);
            board[i][j] = temp;
        }

        private TreeNode buildTree(String[] words) {
            TreeNode root = new TreeNode();
            for (String word : words) {
                TreeNode temp = root;
                for (char ch : word.toCharArray()) {
                    if (temp.childrens[ch - 'a'] == null) {
                        temp.childrens[ch - 'a'] = new TreeNode();
                    }
                    temp = temp.childrens[ch - 'a'];
                }
                temp.isWord = true;
                temp.val = word;
            }
            return root;
        }

        class TreeNode {
            String val;
            TreeNode[] childrens;
            boolean isWord = false;

            public TreeNode() {
                this.childrens = new TreeNode[26];
            }
        }
    }
}
