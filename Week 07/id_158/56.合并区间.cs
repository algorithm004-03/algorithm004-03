/*
 * @lc app=leetcode.cn id=56 lang=csharp
 *
 * [56] 合并区间
 */

// @lc code=start
using System;
using System.Collections.Generic;

public class Solution
{
    public int[][] Merge(int[][] intervals)
    {
        Array.Sort(intervals, (a, b) => a[0] - b[0]);
        Stack<int[]> stack = new Stack<int[]>();

        foreach (int[] a in intervals)
        {

            if (stack.Count == 0) stack.Push(a);
            else
            {

                int[] arr = stack.Pop();
                if (arr[1] >= a[0])
                {
                    int[] combine = { arr[0], Math.Max(arr[1], a[1]) };
                    stack.Push(combine);
                }
                else
                {
                    stack.Push(arr);
                    stack.Push(a);
                }

            }

        }

        return stack.ToArray();
    }
}
// @lc code=end

