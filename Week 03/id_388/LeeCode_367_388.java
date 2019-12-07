package com.company.leetcode.editor.cn;
//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
//
// 说明：不要使用任何内置的库函数，如 sqrt。
//
// 示例 1：
//
// 输入：16
//输出：True
//
// 示例 2：
//
// 输入：14
//输出：False
//
// Related Topics 数学 二分查找



//leetcode submit region begin(Prohibit modification and deletion)
class Solution_367 {

    //牛顿法

    public boolean isPerfectSquare(int num) {

        if (num == 0 || num == 1) {
            return true;
        }

        int left = 1;
        int right = num;
        while (left <= right) {

            int mid = left + (right - left) / 2;
            int res = mid * mid;
            if (res == num) {
                return true;
            }
            if (res > num) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        return false;
    }

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        boolean res = s.isPerfectSquare(14);
//        System.out.println(res);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
