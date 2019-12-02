/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 *
 * https://leetcode.com/problems/edit-distance/description/
 *
 * algorithms
 * Hard (39.94%)
 * Likes:    2678
 * Dislikes: 41
 * Total Accepted:    207.3K
 * Total Submissions: 516.3K
 * Testcase Example:  '"horse"\n"ros"'
 *
 * Given two words word1 and word2, find the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following 3 operations permitted on a word:
 * 
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: word1 = "horse", word2 = "ros"
 * Output: 3
 * Explanation: 
 * horse -> rorse (replace 'h' with 'r')
 * rorse -> rose (remove 'r')
 * rose -> ros (remove 'e')
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: word1 = "intention", word2 = "execution"
 * Output: 5
 * Explanation: 
 * intention -> inention (remove 't')
 * inention -> enention (replace 'i' with 'e')
 * enention -> exention (replace 'n' with 'x')
 * exention -> exection (replace 'n' with 'c')
 * exection -> execution (insert 'u')
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minDistance(String word1, String word2) {
        //使用动态规划的方法
        int n = word1.length();
        int m = word2.length();
    
        // if one of the strings is empty
        if (n * m == 0)
          return n + m;
    
        // array to store the convertion history
        int [][] d = new int[n + 1][m + 1];
    
        // init boundaries
        for (int i = 0; i < n + 1; i++) {
          d[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
          d[0][j] = j;
        }
    
        // DP compute 
        for (int i = 1; i < n + 1; i++) {
          for (int j = 1; j < m + 1; j++) {
            int left = d[i - 1][j] + 1;
            int down = d[i][j - 1] + 1;
            int left_down = d[i - 1][j - 1];
            if (word1.charAt(i - 1) != word2.charAt(j - 1))
              left_down += 1;
            d[i][j] = Math.min(left, Math.min(down, left_down));
    
          }
        }
        return d[n][m];
    }
}
// @lc code=end

