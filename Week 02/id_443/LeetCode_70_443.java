//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划

package com.modds.alltest.leetcode.editor.cn;

public class LeetCode_70_443_ClimbingStairs {
    public static void main(String[] args) {
        Solution solution = new LeetCode_70_443_ClimbingStairs().new Solution();
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int climbStairs(int n) {
            if(n<=2) return n;
            int n1 = 1;
            int n2 = 2;
            for (int i = 3; i <= n; i++) {
                n2 = n1 + n2;
                n1 = n2 - n1;
            }
            return n2;
        }

        public int climbStairs1(int n) {
            if (n == 1) return 1;
            if (n == 2) return 2;
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}