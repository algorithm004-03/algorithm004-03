package com.ljg.leetcode.week06.a02;

/**
 * FendCircles
 */
public class FriendCircles {

    public static void main(String[] args) {
        int[][] M = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };

        FriendCircles fCircles = new FriendCircles();
        int num = fCircles.findCircleNum(M);

        System.out.println("num:" + num);
    }

    private int count;
    private int[] parents;

    private void init(int[][] M) {
        this.count = M.length;
        parents = new int[this.count];
        for (int i = 0; i < this.count; i++) {
            parents[i] = i;
        }
    }

    private int findRoot(int i) {
        int root = parents[i];
        while (root != i) {
            i = root;
            root = parents[i];
        }

        return root;
    }

    private void union(int i, int j) {
        int rootI = findRoot(i);
        int rootJ = findRoot(j);
        
        if(rootI == rootJ) {
            return;
        }

        parents[rootJ] = rootI;
        parents[j] = rootI;
        count--;
    }

    public int findCircleNum(int[][] M) {
        init(M);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if(M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }
}