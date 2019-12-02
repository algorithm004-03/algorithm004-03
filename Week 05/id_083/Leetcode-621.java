import java.util.Arrays;

/*
 * @lc app=leetcode id=621 lang=java
 *
 * [621] Task Scheduler
 *
 * https://leetcode.com/problems/task-scheduler/description/
 *
 * algorithms
 * Medium (46.93%)
 * Likes:    2121
 * Dislikes: 402
 * Total Accepted:    115.8K
 * Total Submissions: 246.7K
 * Testcase Example:  '["A","A","A","B","B","B"]\n2'
 *
 * Given a char array representing tasks CPU need to do. It contains capital
 * letters A to Z where different letters represent different tasks. Tasks
 * could be done without original order. Each task could be done in one
 * interval. For each interval, CPU could finish one task or just be idle.
 * 
 * However, there is a non-negative cooling interval n that means between two
 * same tasks, there must be at least n intervals that CPU are doing different
 * tasks or just be idle.
 * 
 * You need to return the least number of intervals the CPU will take to finish
 * all the given tasks.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * 
 * 
 */

// 由于相同的任务之间必须有 n 的冷却时间，所以我们可以想到按照任务的数量来安排它们，
// 即一种任务的出现次数越多，我们就越早地安排。
// 例如有 5 种任务 A, B, C, D, E，且它们分别有 6, 1, 1, 1, 1 个时，
// 假设冷却时间 n = 2，
// 那么我们首先安排任务 A，
// 随后在 2 单位的冷却时间里，我们安排任务 B, C，
// 随后继续安排任务 A，
// 再安排任务 D, E，以此类推。


// @lc code=start
class Solution {
    public int leastInterval(char[] tasks, int n) {
        // //使用排序方法,时间复杂度O（time）
        // int []map = new int[26];
        // for(char c:tasks){
        //     map[c - 'A']++;
        // }
        // Arrays.sort(map);
        // int time =0;
        // while(map[25]>0){
        //     int i=0;
        //     while(i<=n){
        //         if(map[25] == 0){
        //             break;
        //         }
        //         if(i<26 && map[25-i]>0){
        //             map[25-i] -- ;
        //         }
        //         time ++;
        //         i ++;
        //     }
        //     Arrays.sort(map);
        // }
        // return time;


        //时间复杂度O（M），M为任务的总数
        int []map = new int [26];
        for(char c:tasks){
            map[c - 'A'] ++;
        }
        Arrays.sort(map);
        int max_val = map[25]-1,idle_slots = max_val*n;
        for(int i=24;i>=0;i--){
            idle_slots -= Math.min(map[i], max_val);
        }

        return idle_slots>0 ? idle_slots+tasks.length : tasks.length;
    }
}
// @lc code=end

