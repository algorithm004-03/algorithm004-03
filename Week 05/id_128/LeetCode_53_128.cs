/*
Apparently, this is a optimization problem, which can be usually solved by DP. So when it comes to DP, the first thing for us to figure out is the format of the sub problem(or the state of each sub problem). The format of the sub problem can be helpful when we are trying to come up with the recursive relation.

At first, I think the sub problem should look like: maxSubArray(int A[], int i, int j), which means the maxSubArray for A[i: j]. In this way, our goal is to figure out what maxSubArray(A, 0, A.length - 1) is. However, if we define the format of the sub problem in this way, it's hard to find the connection from the sub problem to the original problem(at least for me). In other words, I can't find a way to divided the original problem into the sub problems and use the solutions of the sub problems to somehow create the solution of the original one.

So I change the format of the sub problem into something like: maxSubArray(int A[], int i), which means the maxSubArray for A[0:i ] which must has A[i] as the end element. Note that now the sub problem's format is less flexible and less powerful than the previous one because there's a limitation that A[i] should be contained in that sequence and we have to keep track of each solution of the sub problem to update the global optimal value. However, now the connect between the sub problem & the original one becomes clearer
*/

//dp
public class Solution
{
    public int MaxSubArray(int[] nums)
    {
        if (nums.Length <= 0) return 0;
        if (nums.Length == 1) return nums[0];

        var dp = new int[nums.Length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.Length; i++)
        {
            dp[i] = nums[i] + Math.Max(0, dp[i - 1]);
        }
        return dp.Max();
    }
}

// dp reduced space
public class Solution
{
    public int MaxSubArray(int[] nums)
    {
        if (nums.Length <= 0) return 0;
        if (nums.Length == 1) return nums[0];

        int subAns = nums[0];
        int opt = subAns;
        for (int i = 1; i < nums.Length; i++)
        {
            subAns = nums[i] + Math.Max(0, subAns);
            opt = Math.Max(subAns, opt);
        }
        return opt;
    }
}