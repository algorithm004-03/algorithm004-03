/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        Arrays.sort(count);
        int result = 0;
        while (count[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (count[25] == 0) {
                    break;
                }
                if (i < 26 && count[25 - i] > 0) {
                    count[25 - i]--;
                }
                result++;
                i++;
            }
            Arrays.sort(count);
        }
        return result;
    }    
}
// @lc code=end

