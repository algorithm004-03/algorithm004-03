package id_693.practise;

/**
 * @Author 李雷（KyLin）
 * @Desc 79. 单词搜索	https://leetcode-cn.com/problems/word-search/
 * @Date 2019/11/21
 */
public class LeetCode_79_693 {
    //dfs解法 标准
    class Solution {
        public boolean exist(char[][] board,String word) {
            if (board.length == 0 || board[0].length == 0 || word.length() == 0) {
                return false;
            }
            int m = board.length;
            int n = board[0].length;
            char[] chars = word.toCharArray();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == word.charAt(0) && backtrack(board,i,j,0,chars)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board,int i,int j,int index,char[] word) {
            if (index == word.length) {
                return true;
            }
            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length) {
                return false;
            }
            if (board[i][j] == word[index]) {
                char temp = board[i][j];
                board[i][j] = '#';
                if (backtrack(board,i + 1,j,index + 1,word)
                        || backtrack(board,i - 1,j,index + 1,word)
                        || backtrack(board,i,j + 1,index + 1,word)
                        || backtrack(board,i,j - 1,index + 1,word)) {
                    return true;
                }
                board[i][j] = temp;
            }

            return false;
        }
    }

    //单词树解法
    class Solution2 {
        public boolean exist(char[][] board,String word) {
            if (board.length == 0 || board[0].length == 0) return false;
            TreeNode root = buildTree(word);
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (dfs(board,root,i,j)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(char[][] board,TreeNode root,int i,int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == '#') {
                return false;
            }
            root = root.childrens[board[i][j] - 'A'];
            if (root == null) {
                return false;
            }
            if (root.isWord) {
                return true;
            }
            char temp = board[i][j];
            board[i][j] = '#';
            if (dfs(board,root,i + 1,j) || dfs(board,root,i - 1,j) || dfs(board,root,i,j - 1) || dfs(board,root,i,j + 1)) {
                return true;
            }
            board[i][j] = temp;
            return false;
        }

        private TreeNode buildTree(String word) {
            TreeNode root = new TreeNode();
            TreeNode temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.childrens[ch - 'A'] == null) {
                    temp.childrens[ch - 'A'] = new TreeNode();
                }
                temp = temp.childrens[ch - 'A'];
            }
            temp.isWord = true;
            return root;
        }

        class TreeNode {
            TreeNode[] childrens;
            boolean isWord = false;

            public TreeNode() {
                this.childrens = new TreeNode[58];
            }
        }
    }
}
