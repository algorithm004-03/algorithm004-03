package id_693;

import java.util.Arrays;

/**
 * @Desc 621. 任务调度器 https://leetcode-cn.com/problems/task-scheduler/
 * @Auther 李雷(KyLin)
 * @Date 2019/11/17
 */
public class LeetCode_621_693 {
    //计数
    public int leastInterval(char[] tasks, int n) {
        int[] dp = new int[26];
        for (char task : tasks) {
            dp[task - 'A']++;
        }
        Arrays.sort(dp);
        int res = (dp[25] - 1) * (n + 1);
        int i = 25;
        while (i >= 0 && dp[i--] == dp[25]) res++;
        return Math.max(res, tasks.length);
    }
}
