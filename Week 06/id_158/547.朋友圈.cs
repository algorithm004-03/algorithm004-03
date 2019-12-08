/*
 * @lc app=leetcode.cn id=547 lang=csharp
 *
 * [547] 朋友圈
 */

// @lc code=start
using System;

public class Solution
{
    public int FindCircleNum(int[][] M)
    {
        int[] parent = new int[M.Length];
        Array.Fill(parent, -1);
        for (int i = 0; i < M.Length; i++)
        {
            for (int j = 0; j < M.Length; j++)
            {
                if (M[i][j] == 1 && i != j)
                {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.Length; i++)
        {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    void union(int[] parent, int x, int y)
    {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }

    int find(int[] parent, int i)
    {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
}
// @lc code=end

