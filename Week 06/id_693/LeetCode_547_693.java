package id_693;

import java.util.Arrays;

/**
 * @Author 李雷（KyLin）
 * @Desc 547. 朋友圈	https://leetcode-cn.com/problems/friend-circles/
 * @Date 2019/11/21
 */
public class LeetCode_547_693 {
    //DFS 解法
    class Solution {
        public int findCircleNum(int[][] M) {
            if (M.length == 0) return 0;
            int[] used = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (used[i] == 0) {
                    dfs(M,used,i);
                    count++;
                }
            }
            return count;
        }

        private void dfs(int[][] M,int[] used,int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[j][i] == 1 && used[j] == 0) {
                    used[j] = 1;
                    dfs(M,used,j);
                }
            }
        }
    }

    //并查集解法
    class Solution2 {
        public int findCircleNum(int[][] M) {
            if (M.length == 0) return 0;
            int[] used = new int[M.length];
            Arrays.fill(used,-1);
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                for (int j = i + 1; j < M.length; j++) {
                    if (M[i][j] == 1) {
                        union(used,i,j);
                    }
                }
            }
            for (int us : used) {
                if (us == -1) count++;
            }
            return count;
        }

        private int find(int[] parent,int i) {
            int temp = i;
            while (parent[i] != -1) {
                i = parent[i];
            }
            //路径压缩
            while (temp != i) {
                int t = parent[temp];
                parent[temp] = i;
                temp = t;
            }
            return i;
        }

        private void union(int[] parent,int i,int j) {
            int xSet = find(parent,i);
            int ySet = find(parent,j);
            if (xSet != ySet) {
                parent[xSet] = ySet;
            }
        }


    }
}
