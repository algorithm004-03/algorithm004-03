/*
 * @lc app=leetcode.cn id=541 lang=csharp
 *
 * [541] 反转字符串 II
 */

// @lc code=start
using System;

public class Solution
{
    public void ReverseArr(char[] arr, int from, int end)
    {
        for (int i = from, j = end; i < j; i++, j--)
        {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
    }
}
// @lc code=end

