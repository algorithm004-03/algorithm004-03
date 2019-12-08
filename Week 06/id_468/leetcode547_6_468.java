package week6;

/**
 * @program: leetcode
 * @description: 朋友圈
 * @author: 王瑞全
 * @create: 2019-11-2421:47
 **/


public class leetcode547_6_468 {
    public int findCircleNum(int[][] M) {
        // return graph(M);
        return uf(M);
    }

    private int uf(int[][] M) {
        int N = M.length, G[] = new int[N], S[] = new int[N];
        for (int i = 0; i < N; i++) {
            G[i] = i;
            S[i] = 1;
        }

        int res = N;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if (M[i][j] != 0) {
                    if (union(G, S, i, j)) res--;
                }
            }
        }
        return res;
    }

    // union-find
    private boolean union(int[] G, int[] S, int i, int j) {
        int gi = find(G, i), gj = find(G, j);
        if (gi == gj) return false;
        if (S[gi] > S[gj]) {
            G[gj] = gi;
            S[gi] += S[gj];
        }
        else {
            G[gi] = gj;
            S[gj] += S[gi];
        }
        return true;
    }

    private int find(int[] G, int i) {
        int j = i;
        while (G[j] != j) j = G[j];
        G[i] = j;
        return j;
    }

    // graph - dfs
    private int graph(int[][] M) {
        int n = M.length, res = 0;
        boolean[] visisted = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visisted[i]) {
                dfs(M, visisted, i);
                res++;
            }
        }
        return res;
    }

    private void dfs(int[][] M, boolean[] visisted, int i) {
        visisted[i] = true;
        for (int j = 0; j < M.length; j++) {
            if (i != j && M[i][j] != 0 && !visisted[j]) {
                M[i][j] = M[j][i] = 1;
                dfs(M, visisted, j);
            }
        }
    }
}

