/*
 * @lc app=leetcode id=552 lang=java
 *
 * [552] Student Attendance Record II
 *
 * https://leetcode.com/problems/student-attendance-record-ii/description/
 *
 * algorithms
 * Hard (34.63%)
 * Likes:    379
 * Dislikes: 74
 * Total Accepted:    16.3K
 * Total Submissions: 47.1K
 * Testcase Example:  '1'
 *
 * Given a positive integer n, return the number of all possible attendance
 * records with length n, which will be regarded as rewardable. The answer may
 * be very large, return it after mod 10^9 + 7.
 * 
 * A student attendance record is a string that only contains the following
 * three characters:
 * 
 * 
 * 
 * 'A' : Absent. 
 * 'L' : Late.
 * ⁠'P' : Present. 
 * 
 * 
 * 
 * 
 * A record is regarded as rewardable if it doesn't contain more than one 'A'
 * (absent) or more than two continuous 'L' (late).
 * 
 * Example 1:
 * 
 * Input: n = 2
 * Output: 8 
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent
 * times. 
 * 
 * 
 * 
 * Note:
 * The value of n won't exceed 100,000.
 * 
 * 
 * 
 * 
 */

// @lc code=start

        //2019.11.15 recursion 时间复杂度O（2^n）
        //f[n]=2f[n−1]−f[n−4]
        //  class Solution {
        //     int M=1000000007;
        //     public int checkRecord(int n) {
        //         int[] f =new int[n+1];
        //         f[0]=1;
        //         for(int i=1;i<=n;i++)
        //             f[i]=func(i);
        //         int sum=func(n);
        //         for(int i=1;i<=n;i++){
        //             sum+=(f[i-1]*f[n-i])%M;
        //         }
        //         return sum%M;
        //     }
        //    public int func(int n)
        //    {    
        //        if(n==0)
        //             return 1;
        //         if(n==1)
        //             return 2;
        //         if(n==2)
        //             return 4;
        //         if(n==3)
        //             return 7;
        //         return (2*func(n-1) - func(n-4))%M;
        //    }
        // }

        //DP 时间复杂度O（n）
        class Solution {
            long M = 1000000007;
            public int checkRecord(int n) {
                long[] f = new long[n <= 5 ? 6 : n + 1];
                f[0] = 1;
                f[1] = 2;
                f[2] = 4;
                f[3] = 7;
                for (int i = 4; i <= n; i++)
                    f[i] = ((2 * f[i - 1]) % M + (M - f[i - 4])) % M;
                long sum = f[n];
                for (int i = 1; i <= n; i++) {
                    sum += (f[i - 1] * f[n - i]) % M;
                }
                return (int)(sum % M);
            }
        }
// @lc code=end

