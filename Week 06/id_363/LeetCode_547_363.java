package com.test.leetcode.week06;

import org.junit.Test;

import java.util.LinkedList;

public class SolutionFriendCircle547 {


    @Test
    public void test1() {
        int[][] m = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int[][] m2 = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };

        int[][] m3 = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        System.out.println(findCircleNum(m));
        System.out.println(findCircleNum(m2));
        System.out.println(findCircleNum(m3));

        System.out.println(findCircleNum2(m));
        System.out.println(findCircleNum2(m2));
        System.out.println(findCircleNum2(m3));


        System.out.println(findCircleNum3(m));
        System.out.println(findCircleNum3(m2));
        System.out.println(findCircleNum3(m3));
    }


    /**
     * A和B是朋友，B和C是朋友，那么A和C也是朋友
     *
     * DFS 使用visited数组表示用户是否被访问过
     * BFS
     * 并查集
     *
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length]; // 表示用户是否被访问过
        int count = 0;
        for (int i = 0; i < M.length; i ++) {
            if (visited[i] == 0) { // 这个用户还没有访问过
                count ++;
                helper(M, visited, i);
            }
        }
        return count;
    }

    private void helper(int[][] m, int[] visited, int i) {
        for (int j = 0; j < m.length; j ++) {
            if (m[i][j] ==  1 && visited[j] == 0) { // 如果i和j是好朋友，那么就把j标志位1，并且去获取j的好朋友
                visited[j] = 1;
                helper(m, visited, j);
            }
        }
    }


    /**
     * 并查集
     * 初始化
     * 如果i和j是好友，那么合并两个集合
     * 求独立的集合的个数
     * @param M
     * @return
     */
    public int findCircleNum2(int[][] M) {
        int n = M.length;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (M[i][j] == 1){
                    unionFind.union(i, j);
                }
            }
        }
        return unionFind.getCount();
    }






    public int findCircleNum3(int[][] M) {
        int[] visited = new int[M.length]; // 表示用户是否被访问过
        int count = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i ++) {
            if (visited[i] == 0) { // 这个用户还没有访问过
                queue.add(i);
                count ++;
                while (! queue.isEmpty()) {
                    Integer j = queue.poll();
                    visited[j] = 1;
                    for (int k = 0; k < M.length; k ++) {
                        if (M[j][k] ==  1 && visited[k] == 0) {
                            queue.add(k);
                        }
                    }
                }
            }
        }
        return count;
    }

}


class UnionFind {
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public int getCount() {
        return count;
    }
}