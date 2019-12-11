/*
思路
并查集维护总共的集合数，总结和书就是最后答案
 */



import java.util.Arrays;

class UnionSet {
    private int len;
    private int[] buf;

    UnionSet(int len) {
        this.len = len;
        buf = new int[len];
        Arrays.setAll(buf, (index)->index);
    }

    private int findRoot(int n) {
        int node;

        node = n;
        while (buf[node] != node) {
            node = buf[node];
        }

        int root = node;

        // 路径压缩
        node = n;
        while (buf[node] != node) {
            int tmp = buf[node];
            buf[node] = root;
            node = tmp;
        }

        return root;
    }

    // 判断两个节点是否在一个集合中
    public boolean isInSameSet(int p, int q) {
        return (findRoot(p) == findRoot(q));
    }

    public void merge(int p, int q) {
        int root_p = findRoot(p);
        int root_q = findRoot(q);

        buf[root_p] = root_q;
    }

}

public class Solution {
    public int findCircleNum(int[][] M) {
        if ((M == null) || (M.length == 0)) {
            return 0;
        }

        if (M[0].length == 0) {
            return 0;
        }

        UnionSet us = new UnionSet(M.length);

        int unionCnt = M.length;
        for (int i = 0; i < M.length; i++) {
            for (int j = i + 1; j < M.length; j++) {
                if (M[i][j] == 0) {
                    continue;
                }

                if (!us.isInSameSet(i, j)) {
                    us.merge(i, j);
                    unionCnt--;
                }
            }
        }

        return unionCnt;
    }

    public static void main(String[] args) {
        new Solution().findCircleNum(new int[][] {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        });
    }
}
