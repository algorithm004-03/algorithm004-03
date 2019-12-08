/*
 * @lc app=leetcode.cn id=72 lang=java
 *
 * [72] 编辑距离
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {

        //1、分治 求minDistance(String word1, String word2)的最大子串
        // 当,最后一位相等时==1+minDistance(String word1.substring(n-1), String word2.substring(n-1)),不等时，即求其少一位的子串
        //2、定义二维状态数组a[i][j]。从空串开始。记录到两者距离(即需要操作的次数)。
        //3、状态方程 当s[i]==s[j]时，a[i][j] =a[i-1][j-1],因为不需要操作
        // 当s[i]！=s[j]时，a[i][j] = 1 + Min(a[i-1][j-1],a[i-1][j],a[i][j-1]),因为分别对应替换，插入，和删除
        int m = word1.length();
        int n = word2.length();
        int dp[][] = new int[m+1][n+1];
        for(int i = 0;i<= m ;i++){
            for(int j = 0; j<= n;j++){
                if(i ==0 && j==0){
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j>0){
                    dp[i][j] = dp[i][j-1] +1;
                    continue;
                }
                if(j == 0 && i>0){
                    dp[i][j] = dp[i-1][j] +1;
                    continue;
                }

                //普适情况,因为数组前面多了一个空串,所以字串数组都减1
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]),dp[i][j-1]);
                }

            }
        }
        return dp[m][n];
    }

}
// @lc code=end

