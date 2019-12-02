package id_693;

/**
 * @Author 李雷（KyLin）
 * @Desc 130. 被围绕的区域 https://leetcode-cn.com/problems/surrounded-regions/
 * @Date 2019/11/21
 */
public class LeetCode_130_693 {
    //dfs解法：先从外围搜索O 转变 成#，然后便利修改数据
    class Solution {
        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) return;
            int m = board.length;
            int n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    boolean edge = i == 0 || j == 0 || i == m - 1 || j == n - 1;
                    if (edge && board[i][j] == 'O') {
                        dfs(board,i,j);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == '#') {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }

        }

        private void dfs(char[][] board,int i,int j) {
            if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] != 'O') {
                return;
            }
            board[i][j] = '#';
            dfs(board,i + 1,j);
            dfs(board,i - 1,j);
            dfs(board,i,j + 1);
            dfs(board,i,j - 1);
        }
    }

    //并查集解法：直接把所有未O的边界组合在一个集合，然后进行其他便利，看周围是否有O，如果有 就和周围的合并,最后边界的O都成为一个集合了
    class Solution2 {
        int[] parent;
        int[] xFront = {1,-1,0,0};
        int[] yFornt = {0,0,-1,1};

        private void unionBuild(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        private int find(int i) {
            int root = i;
            while (parent[i] != i) {
                //路径压缩
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        private void union(int i,int j) {
            int iSet = find(i);
            int jSet = find(j);
            if (iSet != jSet) {
                parent[iSet] = jSet;
            }
        }

        public void solve(char[][] board) {
            if (board.length == 0 || board[0].length == 0) return;
            int m = board.length;
            int n = board[0].length;
            unionBuild(m * n + 1);
            int oJihe = parent[m * n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 边界一个
                    if (board[i][j] == 'O') {
                        if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                            union(i * n + j,oJihe);
                        } else {
                            for (int k = 0; k < 4; k++) {
                                int x = xFront[k] + i;
                                int y = yFornt[k] + j;
                                if(board[x][y] == 'O') {
                                    union(i * n + j,x * n + y);
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (find(i * n + j) == find(oJihe)) {
                        board[i][j] = 'O';
                    } else {
                        board[i][j] = 'X';
                    }
                }
            }

        }
    }
}
